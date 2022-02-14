package zhilian.z220114;

import java.util.concurrent.TimeUnit;

/**
 * @description: synTest
 * https://mp.weixin.qq.com/s/ZcOUB7L0uJB1a9tk7byLqQ
 * @author: zhanghailang
 * @date: 2022/2/14 10:17
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Thread zhl = new Thread(new TicketConsumer(10),"zhl");
        Thread zy = new Thread(new TicketConsumer(10),"zy");
        zhl.start();
        zy.start();
    }

}

class TicketConsumer implements Runnable {

    private volatile static Integer ticket;

    public TicketConsumer(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始抢第 " + ticket + "张票，对象加锁之前：" + System.identityHashCode(ticket));
            synchronized (ticket) {
                System.out.println(Thread.currentThread().getName() + "抢到第" + ticket + "张票，成功锁到的对象：" + System.identityHashCode(ticket));
                if (ticket > 0) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票，票数减一");
                } else {
                    return;
                }
            }
        }
    }
}