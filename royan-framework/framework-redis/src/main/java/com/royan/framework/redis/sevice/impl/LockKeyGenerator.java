package com.royan.framework.redis.sevice.impl;

import cn.hutool.core.util.StrUtil;
import com.royan.framework.redis.annotation.CacheLock;
import com.royan.framework.redis.annotation.CacheParams;
import com.royan.framework.redis.sevice.CacheKeyGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 通过接口注入的方式去写不同的生成规则;
 */
@Service
public class LockKeyGenerator implements CacheKeyGenerator {


    @Override
    public String getLockKey(ProceedingJoinPoint point) {

       MethodSignature signature = (MethodSignature) point.getSignature();
       Method method = signature.getMethod();

       CacheLock cacheLock = method.getAnnotation(CacheLock.class);

       final Object[] args = point.getArgs();
       final Parameter[] parameters = method.getParameters();

       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            final  CacheParams cacheParams = parameters[i].getAnnotation(CacheParams.class);
            if (cacheParams == null){
                continue;
            }
            sb.append(cacheLock.delimiter()).append(args[i]);
        }

        if (StrUtil.isBlank(sb.toString())){
            final Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                final Object object = args[i];
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field :fields){
                   final CacheParams annotation = field.getAnnotation(CacheParams.class);
                   if (annotation == null){
                       continue;
                   }
                   field.setAccessible(true);//将类的成员变量设置为private
                    sb.append(cacheLock.delimiter()).append(ReflectionUtils.getField(field,object));
                }
            }
        }
       return cacheLock.prefix() + sb;
    }
}
