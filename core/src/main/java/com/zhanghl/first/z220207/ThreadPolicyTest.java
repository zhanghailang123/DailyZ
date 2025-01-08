package com.zhanghl.first.z220207;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author hailang.zhang
 * @since 2023-02-11
 */
public class ThreadPolicyTest {

    public static void main(String[] args) throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                System.out.println("callable " + finalI);
                Thread.sleep(500);
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        new Thread(() -> {
            try {
                executorService.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("invokeAll returned");
        }).start();

        Thread.sleep(800);
        System.out.println("shut down");
        List<Runnable> runnables = executorService.shutdownNow();
        for (Runnable r : runnables) {
            if (r instanceof Future) {
                System.out.println("未执行完成任务");
                ((Future<?>) r).cancel(false);
            }
        }
        //executorService.shutdown();
        //两两交换链表的节点
    }

}