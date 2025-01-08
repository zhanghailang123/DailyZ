package com.zhanghl.first.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/9/2 16:15
 */
@Component
public class CacheTest {

//    @Autowired
//    private RedisCacheManager redisCacheManager;
//
//    @Autowired
//    private ConcurrentMapCacheManager cacheManager;

    @Cacheable(value = "name", cacheManager = "redisCacheManager")
    @Async
    public int cache(String name) {
        return 20;
    }
}