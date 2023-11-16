/*     */
package com.goodidea.commons.dto;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.goodidea.commons.exceptions.BizRuntimeException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class RestResponse<T>  extends BaseVo {
    private static final long serialVersionUID = 5043120883324224451L;
    public static final String SUCC_CODE = "0";
    public static final String SUCC_MSG = "success";
    public static final String DEFAULT_ERR_CODE = "100000";
    public static final String DEFAULT_ERR_MSG = "fail";
    protected String exceptCauseIp;
    protected String exceptCauseApp;
    protected String exceptClass;
    protected String exceptStackTrace;
    protected String resultCode;
    protected String resultMsg;
    protected T data;
    protected String exportDataQueryBeanName;
    protected String importDataHandlerBeanName;
    public static final RestResponse<String> SUCCEED = new RestResponse("0", "success");
    public static final RestResponse<String> FAILED = new RestResponse("100000", "fail");
    public static final RestResponse<Void> VOID = new RestResponse((Object)null);
    public static final RestResponse<Boolean> TRUE;
    public static final RestResponse<Boolean> FALSE;
    public RestResponse() {
        this((T) null);
    }

    public RestResponse(T data) {
        this.resultCode = "0";
        this.resultMsg = "success";
        this.data = data;
    }

    public static <T> RestResponse<T> of(T data) {
        return new RestResponse(data);
    }

    public RestResponse(String resultCode, String resutMessage) {
        this.resultCode = resultCode;
        this.resultMsg = resutMessage;
    }

    public RestResponse(String resultCode, String resutMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resutMsg;
        this.data = data;
    }

    public static RestResponse<Long> createLong(Long value) {
        return new RestResponse(value);
    }

    public static RestResponse<Short> createShort(Short value) {
        return new RestResponse(value);
    }

    public static RestResponse<Integer> createInteger(Integer value) {
        return new RestResponse(value);
    }

    public static RestResponse<Float> createFloat(Float value) {
        return new RestResponse(value);
    }

    public static RestResponse<Double> createDouble(Double value) {
        return new RestResponse(value);
    }

    public static RestResponse<BigDecimal> createBigDecimal(BigDecimal value) {
        return new RestResponse(value);
    }

    public static RestResponse<Object> createObject(Object obj) {
        return new RestResponse(obj);
    }

    @JsonInclude(Include.NON_NULL)
    public String getExceptCauseIp() {
        return this.exceptCauseIp;
    }

    public void setExceptCauseIp(String exceptCauseIp) {
        this.exceptCauseIp = exceptCauseIp;
    }

    @JsonInclude(Include.NON_NULL)
    public String getExceptCauseApp() {
        return this.exceptCauseApp;
    }

    public void setExceptCauseApp(String exceptCauseApp) {
        this.exceptCauseApp = exceptCauseApp;
    }

    @JsonInclude(Include.NON_NULL)
    public String getExceptClass() {
        return this.exceptClass;
    }

    public void setExceptClass(String exceptClass) {
        this.exceptClass = exceptClass;
    }

    @JsonInclude(Include.NON_NULL)
    public String getExceptStackTrace() {
        return this.exceptStackTrace;
    }

    public void setExceptStackTrace(String exceptStackTrace) {
        this.exceptStackTrace = exceptStackTrace;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @JsonInclude(Include.NON_NULL)
    public String getExportDataQueryBeanName() {
        return this.exportDataQueryBeanName;
    }

    public void setExportDataQueryBeanName(String exportDataQueryBeanName) {
        this.exportDataQueryBeanName = exportDataQueryBeanName;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getImportDataHandlerBeanName() {
        return this.importDataHandlerBeanName;
    }

    public void setImportDataHandlerBeanName(String importDataHandlerBeanName) {
        this.importDataHandlerBeanName = importDataHandlerBeanName;
    }

    @JSONField(
            serialize = false,
            deserialize = false
    )
    @JsonIgnore
    public boolean isSuccess() {
        return "0".equals(this.resultCode);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap();
        map.put("resultCode", this.resultCode);
        map.put("resultMsg", this.resultMsg);
        map.put("data", this.data);
        return map;
    }

    public static void checkOrThrow(RestResponse<?> restResp) {
        extractData(restResp);
    }

    public static void notAllowNull(RestResponse<?> restResp) {
        if (extractData(restResp) == null) {
            throw new BizRuntimeException("10000", "服务端异常,返回结果为空!");
        }
    }

    public static <T> T extractData(RestResponse<T> restResp) {
        if (restResp == null) {
            return null;
        } else if (restResp.isSuccess()) {
            return restResp.getData();
        } else {
            throw new BizRuntimeException(restResp.getResultCode(), restResp.getResultMsg());
        }
    }

    public String toString() {
        return "RestResponse [resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", data=" + this.data + "]";
    }

    static {
        TRUE = new RestResponse("0", "success", Boolean.TRUE);
        FALSE = new RestResponse("0", "success", Boolean.FALSE);
    }
}



