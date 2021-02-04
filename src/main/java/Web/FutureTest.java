package Web;

import java.util.BitSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 线程相关  future  submit  excute
 * @author: zhanghailang
 * @date: 2020/10/19 0019 22:34
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AtomicInteger integer = new AtomicInteger();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        Future<AtomicInteger> future = poolExecutor.submit(() -> {
            System.out.println("张海浪的成神之路");
            //在这里进行逻辑计算
            integer.set(5201314);
        },integer);
        System.out.println("future的内容：" + future.get());
//        Thread.currentThread().join();
        System.out.println("快快快快快"+Integer.toBinaryString(10));
    }
}