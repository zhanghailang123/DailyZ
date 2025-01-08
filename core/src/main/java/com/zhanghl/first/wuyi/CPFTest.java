package com.zhanghl.first.wuyi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/5/30 17:00
 */
public class CPFTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("在异步中的事情干完了呀");
        }, executorService);

        System.out.println("等待的时候，先去干点别的事");
//        Thread.currentThread().join();
    }
}