package com.royan.framework.redis.aspect;

import cn.hutool.core.util.StrUtil;
import com.royan.framework.redis.annotation.RedissonLock;
import com.royan.framework.redis.exception.CacheLockException;
import com.royan.framework.redis.sevice.RedissonDistributedLocker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description 分布式锁面向切面
 * @date 2022/4/28 22:43:15
 */
@Aspect
@Slf4j
@Component
public class RedissonLockInterceptor {

    @Autowired
    private RedissonDistributedLocker distributedLocker;


    @Around("execution(public * *(..)) && @annotation(com.royan.framework.redis.annotation.RedissonLock)")
    public Object interceptor(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        RedissonLock redissonLock = method.getAnnotation(RedissonLock.class);

        String lockKey = redissonLock.prefix();
        if (StrUtil.isBlank(lockKey)) {
            lockKey = generateKey(point);
        }

        final boolean isLock = distributedLocker.tryLock(lockKey, redissonLock.expire(), redissonLock.expire(), redissonLock.timeUnit());
        if (!isLock) {
            throw new CacheLockException("请勿重复提交!");
        }
        return point.proceed();

    }

    private String generateKey(ProceedingJoinPoint point) {
        StringBuilder sb = new StringBuilder();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        sb.append(point.getTarget().getClass().getName())//类名
                .append(method.getName());//方法名
        for (Object o : point.getArgs()) {
            sb.append(o.toString());
        }
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes(Charset.defaultCharset()));
    }


}
