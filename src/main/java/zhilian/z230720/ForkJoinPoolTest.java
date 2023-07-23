package zhilian.z230720;

import org.springframework.scheduling.concurrent.ForkJoinPoolFactoryBean;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author hailang.zhang
 * @since 2023-07-20
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        //我需要看到 this pool ‘s ability to fork join
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        for (int i = 1; i <= 10; i ++) {
            forkJoinPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + new Date());
            });
        }
//        Thread.yield();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}