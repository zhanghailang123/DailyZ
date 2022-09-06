package com.zhanghl.first.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @description: 缓存配置
 * @author: zhanghailang
 * @date: 2022/9/6 9:44
 */
@Configuration
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport {

    @Override
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String name) {
                return new ConcurrentMapCache(name, CacheBuilder.newBuilder()
                        .expireAfterWrite(30, TimeUnit.MINUTES)
                        .maximumSize(100)
                        .build()
                        .asMap(), false);
            }
        };
        return cacheManager;
    }

    @Bean
    public RedisCacheManager getCacheManager(RedisConnectionFactory factory) {
        RedisCacheManager redisCacheManager =
                RedisCacheManager.builder(factory)
//                        .cacheDefaults(defaultCacheConfig(10000))
                        .transactionAware()
                        .build();
        return  redisCacheManager;

    }
}