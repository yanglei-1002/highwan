package com.crazyplay.highwan.redis.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * <p>
 * 
 * </p>
 * <font size=0.25>Copyright (C) 2019 Yang. All Rights Reserved.</font>
 * @author Yang Lei (Create on:Sep 2, 2019)
 * @version 1.0
 * @fileName RedisConfig.java
 */
@Configuration
public class RedisConfig {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@PostConstruct
	public void initRedisTemplate() {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
	}
	
}
