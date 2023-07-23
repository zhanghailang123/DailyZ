package zhilian.z230720;

import java.util.concurrent.TimeUnit;

/**
 * @author zhanghailang
 * @since 2023/7/23 21:00
 **/
public class ThreadTest {

    public static void main(String[] args) {
        //理解下Join的用法
        Thread b = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行线程b :" + Thread.currentThread().getName());
        });

        Thread a = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行线程a :" + Thread.currentThread().getName());
        });

        a.setDaemon(true);
        a.setDaemon(true);
        a.start();
        b.setDaemon(true);
        b.start();
//        System.out.println("主线程执行 ：" + Thread.currentThread().getName());

//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
