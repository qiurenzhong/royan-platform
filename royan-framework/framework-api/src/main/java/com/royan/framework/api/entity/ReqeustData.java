package com.royan.framework.api.entity;

import lombok.Data;

/**
 * @author Qiurz
 * @date 2020/4/6
 */
@Data
public class ReqeustData<T> {

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
