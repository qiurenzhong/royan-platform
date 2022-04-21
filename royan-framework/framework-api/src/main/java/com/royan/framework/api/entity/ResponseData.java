package com.royan.framework.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一格式返回参数对象
 * @author Qiurz
 * @date 2020/4/6
 */
@Data
public class ResponseData<T> implements Serializable {

    private String code;
    private String msg;
    private T data;
    private boolean success;
    private String traceId;

    public ResponseData(){

    }

    public ResponseData(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public ResponseData(String code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public ResponseData(AppCode appCode) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
    }

    public ResponseData(AppCode appCode, T data) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
        this.data = data;
    }

    public ResponseData setData(T data) {
        this.data = data;
        return this;
    }

    public void ok() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMessage();
    }

    public static <T> ResponseData<T> success() {
        return success(null);
    }

    public static <T> ResponseData<T> success(T data) {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            responseCode = ResponseCode.SYSTEM_EXECUTION_ERROR;
        }
        return result(responseCode, data);
    }


    public static <T> ResponseData<T> success(T data,boolean isSuccess) {
        ResponseData<T> result = new ResponseData<T>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMsg(ResponseCode.SUCCESS.getMessage());
        result.setData(data);
        result.setSuccess(isSuccess);
        return result;
    }

    public static <T> ResponseData<T> failed() {
        return result(ResponseCode.SYSTEM_EXECUTION_ERROR.getCode(), ResponseCode.SYSTEM_EXECUTION_ERROR.getMessage(), null);
    }

    public static <T> ResponseData<T> failed(String msg) {
        return result(ResponseCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> ResponseData<T> failed(AppCode appCode) {
        return result(appCode.getCode(), appCode.getMessage(), null);
    }

    private static <T> ResponseData<T> result(AppCode appCode, T data) {
        return result(appCode.getCode(), appCode.getMessage(), data);
    }

    private static <T> ResponseData<T> result(String code, String msg, T data) {
        ResponseData<T> result = new ResponseData<T>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        result.setSuccess(isSuccess(code));
        return result;
    }


    public static boolean isSuccess(String code) {
        if(ResponseCode.SUCCESS.getCode().equals(code)){
            return true;
        }
        return false;
    }
}
