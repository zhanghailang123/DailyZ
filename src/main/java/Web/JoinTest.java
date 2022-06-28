package Web;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: Join方法是Thread类的一个实例方法。它的作用是让当前线程陷入‘等待’状态，等join的这个线程执行完成后，再继续执行当前线程
 * @author: zhanghailang
 * @date: 2020/9/6 0006 14:09
 */
public class JoinTest {
    static class ThreadA implements Runnable{
        @Override
        public void run(){
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            EXECUTOR_SERVICE.execute((()-> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在执行中ing");
            }));
        }
        Thread.currentThread().join();
        System.out.println("如果不加join方法，我会被先打印出来，加了就不一样了");
    }
}