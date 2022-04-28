package com.royan.framework.redis.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description redisson分布式锁注解
 * @date 2022/4/28 23:03:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedissonLock {

    /**
     * 锁的前缀
     *
     * @return
     */
    String prefix() default "";

    /**
     * 超时时间，默认5s
     *
     * @return
     */
    int expire() default 5;

    /**
     * 超时单位，默认秒
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
