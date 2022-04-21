package com.royan.framework.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *  Redis缓存工具类
 * @author Qiurz
 * @date 2021/4/4
 */
@Component
public class RedisCache {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     *  判断redis键是否存在
     * @param key
     * @return
     */
    public Boolean hasKey(final String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 缓存基本的对象（String,Integer...）,实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObj(final String key,final T value) {
        redisTemplate.opsForValue().set(key,value);
    }


    /**
     * 缓存基本的对象（String,Integer...）,实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout   超时时间
     * @param timeUnit  时间单位（分，秒）
     */
    public <T> void setCacheObj(final String key, final T value, final long timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    /**
     * 获取缓存对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getCacheObj(final String key) {
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 删除缓存对象
     * @param key
     * @return
     */
    public boolean delCacheObj(final String key) {
        return redisTemplate.delete(key);
    }

    /**
     *  删除缓存集合对象
     * @param collection
     * @return
     */
    public long delCacheObjs(final Collection collection) {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     * @param key
     * @param list
     * @param <T>
     * @return
     */
    public <T> long setCacheList(final String key, final List<T> list) {
        Long count = redisTemplate.opsForList().rightPushAll(key,list);
        return count==null? 0:count;
    }

    /**
     * 获取缓存List数据对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> getCacheList(final String key) {
        return redisTemplate.opsForList().range(key,0,-1);
    }


    /**
     * 缓存Set数据
     * @param key
     * @param set
     * @param <T>
     * @return
     */
    public <T> long setCacheSet(final String key, final Set<T> set) {
        Long count = redisTemplate.opsForSet().add(key,set);
        return count==null? 0:count;
    }

    /**
     * 获取缓存Set数据对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> Set<T> getCacheSet(final String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     *  缓存Map数据
     * @param key
     * @param map
     * @param <T>
     */
    public <T> void setCacheMap(final String key, final Map<String, T> map) {
        if (map != null && map.size() > 0) {
            redisTemplate.opsForHash().putAll(key,map);
        }
    }

    /**
     *  获取缓存的Map数据
     * @param key
     * @param <T>
     * @return
     */
    public <T> Map<String,T> getCacheMap(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     *  往hash中存入数据
     * @param key
     * @param hkey
     * @param value
     * @param <T>
     */
    public <T> void setCacheMapValue(final String key,final String hkey,final T value) {
        redisTemplate.opsForHash().put(key,hkey,value);
    }

    /**
     *  获取hash中的数据
     * @param key
     * @param hkey
     * @param <T>
     * @return
     */
    public <T> T getCacheMapValue(final String key,final String hkey) {
        HashOperations<String,String,T> operations = redisTemplate.opsForHash();
        return operations.get(key,hkey);
    }

    /**
     *  获取多个hash中的数据
     * @param key
     * @param hkeys
     * @param <T>
     * @return
     */
    public <T> List<T> getMultiCacheMapValue(final String key,final Collection<Object> hkeys) {
        return redisTemplate.opsForHash().multiGet(key,hkeys);
    }

    /**
     *  获取缓存的基本对象列表
     * @param pattern
     * @return
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     *  设置有效时间
     * @param key 缓存的键值
     * @param timeout   超时时间
     * @param timeUnit  时间单位（分，秒）
     * @return true=设置成功，false=设置失败
     */
    public boolean expire(final String key,final Integer timeout,final TimeUnit timeUnit) {
        return redisTemplate.expire(key,timeout,timeUnit);
    }

    /**
     *  设置有效时间
     * @param key 缓存的键值
     * @param timeout   超时时间
     * @return true=设置成功，false=设置失败
     */
    public boolean expire(final String key,final Integer timeout) {
        return redisTemplate.expire(key,timeout,TimeUnit.SECONDS);
    }

}
