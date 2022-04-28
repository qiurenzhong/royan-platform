package com.royan.framework.redis.aspect;

import cn.hutool.core.util.StrUtil;
import com.royan.framework.redis.annotation.RedisLock;
import com.royan.framework.redis.annotation.ReqParams;
import com.royan.framework.redis.exception.CacheLockException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Slf4j
@Component
public class RedisLockInterceptor {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisLockInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Around("execution(public * *(..)) && @annotation(com.royan.framework.redis.annotation.RedisLock)")
    public Object interceptor(ProceedingJoinPoint point) {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        RedisLock redisLock = method.getAnnotation(RedisLock.class);

        if (StrUtil.isBlank(redisLock.prefix())) {
            throw new RuntimeException("lock key is not null");
        }

        // 获取key
        final String lockKey = getLockKey(point);
        try {

            final Boolean hasLockKeyFlag = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "");
            if (hasLockKeyFlag) {
                stringRedisTemplate.expire(lockKey, redisLock.expire(), redisLock.timeUnit());
            } else {
                throw new CacheLockException("请勿重复提交!");
            }

            try {
                return point.proceed();
            } catch (Throwable e) {
                throw new RuntimeException("系统异常: " + e.getMessage());
            }
        } finally {
            stringRedisTemplate.delete(lockKey);
        }

    }

    private String getLockKey(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        final Object[] args = point.getArgs();
        final Parameter[] parameters = method.getParameters();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            final ReqParams reqParams = parameters[i].getAnnotation(ReqParams.class);
            if (reqParams == null) {
                continue;
            }
            sb.append(":").append(args[i]);
        }

        if (StrUtil.isBlank(sb.toString())) {
            final Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                final Object object = args[i];
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field : fields) {
                    final ReqParams annotation = field.getAnnotation(ReqParams.class);
                    if (annotation == null) {
                        continue;
                    }
                    //将类的成员变量设置为private
                    field.setAccessible(true);
                    sb.append(":").append(ReflectionUtils.getField(field, object));
                }
            }
        }
        return sb.toString();
    }
}
