package com.zhanghl.first.z220207.bytedance;

import java.util.concurrent.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/9/23 16:44
 */
public class T0923_1 {

    private static final ExecutorService executor = new ThreadPoolExecutor(
            10,
            20,
            5L,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(5000),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) {
//        for (int i = 0; i < 100000000; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }, executor);
//        }
    }
}