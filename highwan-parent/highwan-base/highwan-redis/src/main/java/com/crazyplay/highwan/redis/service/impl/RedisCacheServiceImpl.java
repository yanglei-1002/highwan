package com.crazyplay.highwan.redis.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.crazyplay.highwan.redis.service.RedisCacheService;

/**
 * <p>
 * 
 * </p>
 * <font size=0.25>Copyright (C) 2019 Yang. All Rights Reserved.</font>
 * @author Yang Lei (Create on:Sep 2, 2019)
 * @version 1.0
 * @fileName RedisCacheServiceImpl.java
 */
public class RedisCacheServiceImpl implements RedisCacheService{
    
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
    
    @Override
    public void set(String key, String value, Long time) {
//        redisTemplate.opsForValue().setIfAbsent(key, value, time, TimeUnit.MINUTES);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public Long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key,timeUnit);
    }

}
