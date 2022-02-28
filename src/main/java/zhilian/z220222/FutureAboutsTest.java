package zhilian.z220222;

import java.util.concurrent.*;

/**
 * @description: Future相关的学习
 * https://mp.weixin.qq.com/s?__biz=Mzg3NjU3NTkwMQ==&mid=2247505139&idx=1&sn=a179eb62e2555e5be198bcecde217f67&chksm=cf32b901f8453017f5f169ac394dd6db348b6ef5b2163bcdb6a13277e80e518ff0a058683b61&scene=21#wechat_redirect
 * https://mp.weixin.qq.com/s/bnItRL-z-Pak8Diup3lZGw
 * @author: zhanghailang
 * @date: 2022/2/22 0022 22:34
 */
public class FutureAboutsTest {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Future<?> future = executorService.submit(() -> {
//            System.out.println("zy is a han han");
////            return "zzzzzz";
//        });
//
//        try {
//            System.out.println(future.get() + "-----返回");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() ->{
                FutureAboutsTest.testu();
            });
        }

    }

    public static void testu() {
        FutureTask testFuture = new FutureTask<String>(() -> {
            TimeUnit.SECONDS.sleep(5);
            return "zzzz";
        });
        testFuture.run();
        try {
            System.out.println("返回结果 ：" + testFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}