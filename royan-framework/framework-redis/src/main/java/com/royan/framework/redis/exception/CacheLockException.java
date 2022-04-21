package com.royan.framework.redis.exception;

/**
 * 自定义分布式锁异常
 */
public class CacheLockException extends RuntimeException{

    public CacheLockException(String message){
        super(message);
    }
}
