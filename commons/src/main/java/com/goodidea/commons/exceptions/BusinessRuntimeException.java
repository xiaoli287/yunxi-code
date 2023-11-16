package com.goodidea.commons.exceptions;


import com.alibaba.fastjson.JSONObject;
import com.goodidea.commons.dto.RestResponse;

import java.util.HashMap;
import java.util.Map;


public class BusinessRuntimeException
        extends RuntimeException {
    private static final long serialVersionUID = 1L;
    protected static Map<String, String> mapMessage = new HashMap<String, String>();

    public static final String SYSTEM_INTERNAL_ERROR = "10001";
    public static final String PARAMETER_ERROR = "10002";
    public static final String RECORD_DUPLICATED = "11001";
    public static final String RECORD_NOTEXIST = "11002";
    public static final String APIGATEWAY_ERROR = "99999";

    static {
        mapMessage.put("10001", "系统内部错误");
        mapMessage.put("10002", "业务参数异常");
        mapMessage.put("11001", "记录重复");
        mapMessage.put("11002", "记录不存在");
    }


    protected String code = null;
    protected String rawMessage = null;


    public BusinessRuntimeException(String message) {
        this("10001", message);
    }


    public BusinessRuntimeException(String message, Throwable e) {
        this("10001", message, e);
    }


    public BusinessRuntimeException(String code, String message) {
        super("{\"code\":\"" + code + "\", \"message\":\"" + message + "\"}");
        this.code = code;
        this.rawMessage = message;
    }


    public BusinessRuntimeException(String code, String message, Throwable e) {
        super("{\"code\":\"" + code + "\", \"message\":\"" + message + "\"}", e);
        this.code = code;
        this.rawMessage = message;
    }


    public String getCode() {
        return this.code;
    }


    public String getRawMessage() {
        return this.rawMessage;
    }

    public String toRestResponseJson() {
        return JSONObject.toJSONString(new RestResponse(this.code, this.rawMessage));

    }


    public static String getMessage(int code) {
        return mapMessage.get(Integer.valueOf(code));
    }
}

