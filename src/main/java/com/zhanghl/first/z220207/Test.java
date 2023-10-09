//package com.zhanghl.first.z220207;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @author hailang.zhang
// * @since 2023-09-21
// */
//public class Test {
//
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
//        for (int i = 0; i < 10; i++) {
//            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//
//        Thread.startVirtualThread(() -> {
//            System.out.println(Thread.currentThread());
//        });
//
//        Thread.ofVirtual().start(() -> {
//            System.out.println(Thread.currentThread());
//        });
//    }
//}