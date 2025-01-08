package zhilian.z0830;

import java.util.concurrent.CountDownLatch;

/**
 * @description: CountDownLatch让一些线程阻塞到另一些线程完成一系列操作后被唤醒
 * @author: zhanghailang
 * @date: 2020/9/19 0019 10:43
 */
public class CountDownLatchDemo {
    final static int studentsNum = 10;

    //模拟下晚自习，班长最后关门   Alt + Shift + Enter  快速生成异常
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(studentsNum);
        for (int i = 0; i < studentsNum; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                count.countDown();
                System.out.println("当前还剩余几位同学没离开：：" +count.getCount());
            },String.valueOf(i)).start();
        }

        //主线程main，班长调用await，方法阻塞自己，直至计数器数值为0
        count.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长锁门，离开教室");
    }


}