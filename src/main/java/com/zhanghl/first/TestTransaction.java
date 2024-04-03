package com.zhanghl.first;

import com.zhanghl.first.cache.CacheTest;
//import com.zhanghl.first.z220207.RedisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: first
 * @author: zhanghailang
 * @date: 2022/1/5 17:43
 */
@RestController
public class TestTransaction {

    @PutMapping(value = "/test-transatioanl")
    public void testTransaction(){
        this.method1();
    }
//
//    @Autowired
//    private RedisTest redisTest;

    @Autowired
    private CacheTest cacheTest;

//    @Transactional(rollbackFor = Exception.class)
    public void method1(){
        System.out.println("first transactional start");
        throw new RuntimeException("first transactional ex");
    }
//
//    @GetMapping(value = "/redisTest")
//    public void redisTest(){
//        this.redisTest.testHyperLogLog();
//    }

    @GetMapping(value = "/testCache")
    public int testCache(String name){
        return this.cacheTest.cache(name);
    }
}