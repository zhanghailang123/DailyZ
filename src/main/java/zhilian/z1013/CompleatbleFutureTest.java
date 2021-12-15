package zhilian.z1013;

import org.springframework.util.Base64Utils;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description:  https://mp.weixin.qq.com/s/EXm0QyNdhLckI-WADXxupA
 * CompletableFuture的使用
 * @author: zhanghailang
 * @date: 2021/10/13 0013 22:29
 */
public class CompleatbleFutureTest {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
////        CompletableFuture.runAsync( ()->{
////
////        });
////        CompletableFuture.supplyAsync( () ->{
////            return "111";
////        }).whenComplete();
////        List<String> testStream = new ArrayList<>();
////        testStream.parallelStream().distinct();

        CompletableFuture.supplyAsync(() ->{
            System.out.println("我开始异步做一些其他的事");
            System.out.println(Thread.currentThread().getName());
            try {

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "我异步的事做完了";
        }).whenComplete((aaa,bbbb) ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("异步的结果是什么：" + aaa);
        });
//        TimeUnit.SECONDS.sleep(5000);
        System.out.println("在异步的时候可不可以做一些其他的事");
        Thread.currentThread().join();

        LongAdder adder = new LongAdder();
        adder.increment();
    }
}