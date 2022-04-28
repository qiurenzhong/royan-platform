package com.royan.framework.redis.annotation;

import java.lang.annotation.*;

/**
 * redis分布式锁的参数
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ReqParams {

    /**
     * 字段名称
     *
     * @return
     */
    String name() default "";


}
