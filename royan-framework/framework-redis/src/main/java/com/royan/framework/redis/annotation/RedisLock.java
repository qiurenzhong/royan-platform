package com.royan.framework.redis.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLock {

    /**
     * 锁的前缀
     *
     * @return
     */
    String prefix() default "";

    /**
     * 超时时间，默认5s
     * @return
     */
    int expire() default 5;

    /**
     * 超时单位，默认秒
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * key的分隔符（默认：）
     * @return
     */
    String delimiter() default ":";


}
