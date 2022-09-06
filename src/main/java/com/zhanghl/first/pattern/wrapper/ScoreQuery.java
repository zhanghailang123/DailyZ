package com.zhanghl.first.pattern.wrapper;

import io.vavr.control.Try;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/8/30 12:39
 */
public class ScoreQuery implements Computable<String, Integer>{

    @Override
    public Integer compute(String userName) throws Exception {
        System.out.println("开始查询：" + userName + "分数");
        Thread.sleep(5);
//        Try.of()
        return ThreadLocalRandom.current().nextInt(380,420);
    }
}