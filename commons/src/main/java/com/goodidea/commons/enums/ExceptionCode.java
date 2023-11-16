package com.goodidea.commons.enums;


public interface ExceptionCode {
    public static final ExceptionCode SUCCESS = newInstance("0", "操作成功");

    public static final ExceptionCode FAIL = newInstance("100000", "操作失败");

    public static final ExceptionCode NOT_SUPPORTED = newInstance("100001", "渠道不支持该接口");

    public static final ExceptionCode INVOKE = newInstance("-2", "接口调用失败");

    public static final ExceptionCode VALIDATION_FAIL = newInstance("1000", "数据验证失败");

    public static final ExceptionCode INVALID_PARAM = newInstance("2000", "参数不合法");

    public static final ExceptionCode DAO_ERR = newInstance("60000", " 数据库访问异常");

    public static final ExceptionCode SYSTEM_ERR = newInstance("100001", "系统异常，请联系管理员");

    public static final ExceptionCode USER_DEFINED = newInstance("100002", "用戶限制");

    static ExceptionCode newInstance(final String code, final String name) {
        return new ExceptionCode() {
            public String getCode() {
                return code;
            }


            public String getMsg() {
                return name;
            }
        };
    }

    String getCode();

    String getMsg();
}

