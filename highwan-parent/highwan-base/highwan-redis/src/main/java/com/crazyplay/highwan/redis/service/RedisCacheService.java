package com.crazyplay.highwan.redis.service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 
 * </p>
 * <font size=0.25>Copyright (C) 2019 Yang. All Rights Reserved.</font>
 * @author Yang Lei (Create on:Sep 2, 2019)
 * @version 1.0
 * @fileName RedisCacheService.java
 */
public interface RedisCacheService {
    
    /**
     * 设置缓存
     * @param key  key
     * @param value 需缓存的对象
     */
    public void set(String key,String value);
    
    /**
     * @param key
     * @param value
     * @param time 过期时间（分钟）
     */
    public void set(String key,String value,Long time);
    
    /**
     * 获取缓存
     * @param key
     * @return
     */
    public String get(String key);
    
    /**
     * 删除缓存
     * @param key
     */
    public void delete(String key);
    
    /**
     * 获取缓存过期时间
     * @param key
     */
    public Long getExpire(String key);
    
    /**
     * 获取缓存过期时间
     * @param key
     */
    public Long getExpire(String key,TimeUnit timeUnit);
}
