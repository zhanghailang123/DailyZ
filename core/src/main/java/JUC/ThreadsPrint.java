package JUC;

/**
 * @description: 多线程打印问题
 * A、B、C
 * @author: zhanghailang
 * @date: 2021-5-13 19:02
 */
public class ThreadsPrint {
    private static final int Max = 10;
    private static int index = 1;

    public static void main(String[] args) {
        Object lock = new Object();
//        new Thread(()->{
//            System.out.println("aaa");
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("zzzz");
//            }
//        }).start();
//
//        Thread a = new Thread(() ->{
//            System.out.println("ttttt");
//        });
//        a.start();
//        System.out.println(a.getName());

        /**
         * 此问题引发的思考
         * 1.多线程的交替执行 通信
         * 2.锁的使用
         * 3.wait阻塞和唤醒锁
         * 4.取余数问题
         */

        Thread ta = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < Max; i++) {
                    while (index % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    index ++;
                    lock.notifyAll();
                    System.out.print("A");
                }
            }
        });

        Thread tb = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < Max; i++) {
                    while (index % 3 != 2){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                    System.out.print("B");
                    index ++;
                }
            }
        });

        Thread tc = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < Max; i++) {
                    while (index % 3 != 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                    System.out.print("C");
                    index ++ ;
                }
            }

        });
        ta.start();
        tb.start();
        tc.start();
//        System.out.println("测试" + 1 % 3);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}