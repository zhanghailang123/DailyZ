package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 多线程打印之使用ReetrantLock
 * @author: zhanghailang
 * @date: 2021-5-14 19:30
 */
public class ThreadsPrint2 {
    private static final int Max = 10;
    private static int index = 1;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread ta = new Thread(() ->{
            lock.lock();
            for (int i = 0; i < Max; i ++){
                while (index % 3 != 1 ){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("A");
                index ++;
                condition.signalAll();
            }
            lock.unlock();
        });


        Thread tb = new Thread(() ->{
            lock.lock();
            for (int i = 0; i < Max; i ++){
                while (index % 3 != 2){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("B");
                index ++;
                condition.signalAll();
            }
            lock.unlock();
        });


        Thread tc = new Thread(() -> {
            lock.lock();
            for (int  i = 0; i < Max; i ++){
                while (index % 3 != 0){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("C ");
                index ++;
                condition.signalAll();
            }
            lock.unlock();
        });


        ta.start();
        tb.start();
        tc.start();

    }
}