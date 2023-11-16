
package com.goodidea.commons.exceptions;


import cn.hutool.core.util.ArrayUtil;
import com.goodidea.commons.enums.ExceptionCode;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BizRuntimeException
        extends BusinessRuntimeException {
    public BizRuntimeException(String message) {
        super(ExceptionCode.FAIL.getCode(), message);
    }

    public BizRuntimeException(String message, Throwable e) {
        super(message, e);
    }

    public BizRuntimeException(String code, String message) {
        super(code, message);
    }

    public BizRuntimeException(String code, String message, Throwable e) {
        super(code, message, e);
    }

    public static BizRuntimeException format(String format, Object... args) {
        return builder()
                .message(format, args)
                .build();
    }

    public static BizRuntimeException format(Throwable throwable, String format, Object... args) {
        return builder()
                .message(format, args)
                .throwable(throwable)
                .build();
    }

    public static BizRuntimeExceptionBuilder builder() {
        return new BizRuntimeExceptionBuilder();
    }

    public static class BizRuntimeExceptionBuilder {
        String format;
        Object[] args;
        Map<String, Object> showVariables = new LinkedHashMap<>(4);


        Throwable throwable;


        public BizRuntimeException build() {
            String message = "";
            if (StringUtils.isNotBlank(this.format)) {
                message = String.format(this.format, this.args);
            } else if (null != this.throwable) {
                message = this.throwable.getMessage();
            }

            if (this.showVariables.isEmpty()) {
                return new BizRuntimeException(message, this.throwable);
            }


            String showVariableStr = this.showVariables.entrySet().stream().map(entry -> {
                Object value = parseShowVariableValue(entry.getValue());
                return String.format("【%s=%s】", new Object[]{entry.getKey(), value});
            }).collect(Collectors.joining(","));
            message = message + ": " + showVariableStr;
            return new BizRuntimeException(message, this.throwable);
        }

        protected Object parseShowVariableValue(Object value) {
            if (value == null) {
                return "null";
            }
            if (value.getClass().isArray()) {
                return ArrayUtil.toString(value);
            }
            if (!(value instanceof Supplier)) {
                return value;
            }
            return parseShowVariableValue(((Supplier) value).get());
        }

        public BizRuntimeExceptionBuilder message(String format, Object... args) {
            this.format = format;
            this.args = args;
            return this;
        }

        public BizRuntimeExceptionBuilder showVariable(String name, Object value) {
            this.showVariables.put(name, value);
            return this;
        }

        public BizRuntimeExceptionBuilder showVariable(String name, Supplier<?> value) {
            this.showVariables.put(name, value);
            return this;
        }
        public BizRuntimeExceptionBuilder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        private BizRuntimeExceptionBuilder() {
        }
    }
}


