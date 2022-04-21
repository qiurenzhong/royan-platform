package com.royan.framework.redis.aspect;

import cn.hutool.core.util.StrUtil;
import com.royan.framework.redis.annotation.CacheLock;
import com.royan.framework.redis.exception.CacheLockException;
import com.royan.framework.redis.sevice.CacheKeyGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.Method;

@Aspect
@Configuration
public class LockMethodInterceptor {

    private final StringRedisTemplate stringRedisTemplate;
    private final CacheKeyGenerator cacheKeyGenerator;

    public LockMethodInterceptor(StringRedisTemplate stringRedisTemplate,CacheKeyGenerator cacheKeyGenerator){
        this.cacheKeyGenerator = cacheKeyGenerator;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Around("execution(public * *(..)) && @annotation(com.royan.framework.redis.annotation.CacheLock)")
    public Object interceptor(ProceedingJoinPoint point){

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CacheLock cacheLock = method.getAnnotation(CacheLock.class);

        if (StrUtil.isBlank(cacheLock.prefix())){
            throw new RuntimeException("lock key is not null");
        }

        // 获取key
        final String lockKey = cacheKeyGenerator.getLockKey(point);
        try {

           final Boolean hasLockKeyFlag = stringRedisTemplate.opsForValue().setIfAbsent(lockKey,"");
           if (hasLockKeyFlag){
               stringRedisTemplate.expire(lockKey,cacheLock.expire(),cacheLock.timeUnit());
           }else {
                throw new CacheLockException("请勿重复提交!");
           }

            try {
                return point.proceed();
            } catch (Throwable e) {
                throw new RuntimeException("系统异常: " + e.getMessage());
            }
        }finally {
            stringRedisTemplate.delete(lockKey);
        }

    }
}
