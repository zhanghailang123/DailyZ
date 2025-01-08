package com.zhanghl.first.wuyi;

import java.util.concurrent.TimeUnit;

/**
 * @description: 守护线程测试
 * @author: zhanghailang
 * @date: 2022/5/2 0002 21:33
 */
public class SetDamonTest {

    public static void main(String[] args) {
        System.out.println("主线程开始执行" + Thread.currentThread().getName());
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是一个用户线程的执行");
        }).start();

        Thread damonThread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("守护线程在运行");
            }
        });
        damonThread.setDaemon(true);
        damonThread.start();
        System.out.println("主线程运行结束");
    }
}