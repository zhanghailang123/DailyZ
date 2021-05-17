package JUC;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 多线程打印的第三种解法
 * 产生一个疑问CountDownLatch能不能解决这个问题呢？
 * @author: zhanghailang
 * @date: 2021-5-14 20:02
 */
public class ThreadsPrint3 {
    private static final int MAX = 10;
    private static int temp = 1;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Thread ta = new Thread(() ->{
            for (int i = 0; i < MAX; i ++){
                while (temp %3 != 1){

                }
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("A");
                semaphore.release();
                temp ++;
            }
        });

        Thread tb = new Thread(() ->{
            for (int i = 0; i < MAX; i ++){
                while (temp %3 != 2){

                }
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");
                semaphore.release();
                temp ++;
            }
        });

        Thread tc = new Thread(() ->{
            for (int i = 0; i < MAX; i ++){
                while (temp %3 != 0){

                }
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("C");
                System.out.println();
                semaphore.release();
                temp ++;
            }
        });

        ta.start();
        tb.start();
        tc.start();




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("另一种的许可证使用解法开始 ====== ");

        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        Thread ta1 = new Thread(() -> {
            for (int i = 0; i < MAX; i++){
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("A");
                semaphoreB.release();
            }
        });

        Thread tb1 = new Thread(() -> {
            for (int i = 0; i < MAX; i++){
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");
                semaphoreC.release();
            }
        });

        Thread tc1 = new Thread(() -> {
            for (int i = 0; i < MAX; i ++){
                try {
                    semaphoreC.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("C");
                semaphoreA.release();
            }
        });

        ta1.start();
        tb1.start();
        tc1.start();
    }
}