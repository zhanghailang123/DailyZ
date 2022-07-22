package com.zhanghl.first.z220207;

import cn.hutool.core.util.NumberUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/7 9:39
 */
@Service
public class TransactionalTest {

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        System.out.println("start transactional test");
        throw new RuntimeException("test rollback");
    }

    public static void main(String[] args) {
        Double a = 111.0;
        Double b = 24.33;
        System.out.println(NumberUtil.round((a+b),2));
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,5, TimeUnit.SECONDS,new ArrayBlockingQueue<Long>(100));
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}