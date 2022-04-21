package com.royan.framework.redis.sevice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *  key的生成器
 */
public interface CacheKeyGenerator {

    /**
     * 获取AOP参数,生成指定缓存Key
     * @param point
     * @return
     */
    String getLockKey(ProceedingJoinPoint point);
}
