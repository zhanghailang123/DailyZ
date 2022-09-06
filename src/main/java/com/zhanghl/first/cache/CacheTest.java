package com.zhanghl.first.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/9/2 16:15
 */
@Component
public class CacheTest {


    @Autowired
    private ConcurrentMapCacheManager cacheManager;

    @Cacheable(value = "name", cacheManager = "cacheManager")
    public int cache(String name) {
        return 20;
    }
}