package main.java.aboutthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: 回环屏障，直到所有的线程都达到屏障之后，屏障才会开门，到达屏障之后调用await方法，
 * countdownLatch相当于在做减法，而cylicbarrier相当于在做加法，当await到一个指定的值的时候才能穿过屏障
 * @author: zhanghailang
 * @date: 2020/9/19 0019 11:01
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
            System.out.println("召唤神龙");
        });

        for (int i = 0; i < 10; i ++){
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集到第 " + temp +" 个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(temp)).start();
        }

        System.out.println(cyclicBarrier.getNumberWaiting());

    }
}