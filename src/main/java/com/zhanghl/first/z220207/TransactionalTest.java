package com.zhanghl.first.z220207;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/7 9:39
 */
@Service
public class TransactionalTest {

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {

    }

    public static void main(String[] args) {
//        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println(1111);
//            return 111;
//        }).thenApply(a -> {
//            System.out.println("then apply 输出" + a);
//            return "2";
//        }).thenApply(b -> {
//            System.out.println("then apply 输出2 " + b);
//            return 1L;
//        });
//
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String s = "123456";
        for (char c : s.toCharArray()) {
            System.out.println(c - '0');
        }
    }

}