package com.goodidea.yunxi.handler;

import com.goodidea.commons.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.concurrent.atomic.AtomicReference;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 以 JSON 格式返回校验异常信息
     * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse handleValidationException(MethodArgumentNotValidException e) {
        AtomicReference<String> errorMessages = new AtomicReference<>("");
        e.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError)error).getField(); // 字段名
                    String errorMessage = error.getDefaultMessage(); // 校验失败信息
                    errorMessages.set("[" +fieldName + "]" + errorMessage);
                });

        return new RestResponse("-1,", errorMessages.get());
    }
}
