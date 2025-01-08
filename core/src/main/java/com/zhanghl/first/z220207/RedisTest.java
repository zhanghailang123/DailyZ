package com.zhanghl.first.z220207;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/3/31 17:19
 */
@Component
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    public void testHyperLogLog() {
        redisTemplate.opsForHyperLogLog().add(1,1,2,3);
    }

    /**
     * 延时队列
     */
    public void testRedisDelayQueue() {

    }

    public void produceDelayMessage() {
        for (int i = 0; i < 10; i++) {
            this.redisTemplate.opsForZSet().add("OrderId",i,i);
            Set set = this.redisTemplate.opsForZSet().rangeByScore("OrderId",0,1);
        }
    }
}