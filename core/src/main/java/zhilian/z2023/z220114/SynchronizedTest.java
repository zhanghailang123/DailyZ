package zhilian.z2023.z220114;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description: synTest
 * https://mp.weixin.qq.com/s/ZcOUB7L0uJB1a9tk7byLqQ
 * @author: zhanghailang
 * @date: 2022/2/14 10:17
 */
public class SynchronizedTest {
    //https://mp.weixin.qq.com/s/gvZ009wPwkUmOAwy707Uaw
    //异常和危险的情况下，系统生存的能力；在计算机科学中，鲁棒性是指一个计算机系统在执行过程中处理错误，以及算法在遭遇输入、运算等异常时继续运行的能力
    //鲁棒性关注的重点是系统的稳定性
    public static void main(String[] args) {
        Thread zhl = new Thread(new TicketConsumer(10),"zhl");
        Thread zy = new Thread(new TicketConsumer(10),"zy");
        zhl.start();
        zy.start();
    }

}

class TicketConsumer implements Runnable {

    /**
     * 请注意这个Integer类型
     */
    private volatile static Integer ticket;

    private volatile ConcurrentHashMap<Integer,Integer> locks = new ConcurrentHashMap<>();

    public TicketConsumer(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始抢第 " + ticket + "张票，对象加锁之前：" + System.identityHashCode(ticket));
//            synchronized (ticket) {
            //正确的做法
            synchronized (getCacheSyncObject(ticket)) {
                System.out.println(Thread.currentThread().getName() + "抢到第" + getCacheSyncObject(ticket) + "张票，成功锁到的对象：" + System.identityHashCode(ticket));
                if (getCacheSyncObject(ticket) > 0) {
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

    private Integer getCacheSyncObject(final Integer id) {
        if (locks.putIfAbsent(id,id) != null) {
//            System.out.println("aaaa:  " + id);
        }
        return locks.get(id);
    }
}