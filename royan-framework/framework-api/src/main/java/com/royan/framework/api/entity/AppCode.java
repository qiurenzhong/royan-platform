package com.royan.framework.api.entity;

/**
 * @author Qiurz
 * @date 2020/4/5
 */
public interface AppCode {

    String getCode();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);

    default boolean ok() {
        return "00000".equals(this.getCode());
    }
}
