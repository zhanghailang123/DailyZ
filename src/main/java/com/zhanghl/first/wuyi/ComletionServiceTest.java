package com.zhanghl.first.wuyi;


import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/5/9 0009 21:18
 */
public class ComletionServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step1 ~");
            System.out.println(Thread.currentThread().getName());
//            System.out.println(1/0);
            return 11;
        }).whenCompleteAsync((a,b) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(a + "====" + b);
        });

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step2 ~");
            return 22;
        });

        completableFuture1.thenCombine(completableFuture2, (a,b) ->{
            System.out.println(a + b);
            return "Step 3 ~";
        }).thenAccept(c -> {
            System.out.println(c);
        });
    }
}