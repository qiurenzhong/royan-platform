package com.royan.framework.api.entity;

import lombok.Data;

/**
 * @author Qiurz
 */
@Data
public class RequestData<T> {

    private String appId;
    private String device;
    private String os;
    private String version;
    private String appPrivateKey;
    private String random;
    private String accessToken;
    private String refreshToken;
    private String tid;
    private String clazz;
    private T data;
}
