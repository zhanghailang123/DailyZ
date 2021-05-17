package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReetrantLock和Condition的结合使用
 * use of ReentrantLock And Condition
 * @author: zhanghailang
 * @date: 2021-5-14 23:44
 */
public class ReenAndCondition {
    //  线程之间协作：子线程循环2次，接着主线程循环4次，
    //  接着又回到子线程循环2次，接着再回到主线程又循环4次，如此循环5次。
//    new Condition
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        for (int i = 0; i < 5; i++) {


            Thread a = new Thread(() -> {
                lock.lock();
                for (int j = 0; j < 2; j++) {
                    System.out.println("子线程aaaa");

                }
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.unlock();

            });
            a.start();
//
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                conditionB.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.lock();

            for (int m = 0; m < 4; m++) {
                System.out.println("主线程");

            }
            conditionA.signal();
            lock.unlock();
        }
    }
}