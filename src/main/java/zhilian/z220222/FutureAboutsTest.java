package zhilian.z220222;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: Future相关的学习
 * https://mp.weixin.qq.com/s?__biz=Mzg3NjU3NTkwMQ==&mid=2247505139&idx=1&sn=a179eb62e2555e5be198bcecde217f67&chksm=cf32b901f8453017f5f169ac394dd6db348b6ef5b2163bcdb6a13277e80e518ff0a058683b61&scene=21#wechat_redirect
 * @author: zhanghailang
 * @date: 2022/2/22 0022 22:34
 */
public class FutureAboutsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?> future = executorService.submit(() -> {
            System.out.println("zy is a han han");
//            return "zzzzzz";
        });

        try {
            System.out.println(future.get() + "-----返回");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}