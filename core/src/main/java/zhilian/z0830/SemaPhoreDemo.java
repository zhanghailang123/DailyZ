package zhilian.z0830;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: SemaPhore用于限制可以访问某些资源的线程数目，他维护了一个许可证集合，有多少资源需要限制就维护多少许可证集合
 * 主要强调只有某些个数量的线程可以拿到资源执行。
 * @author: zhanghailang
 * @date: 2020/9/19 0019 11:14
 */
public class SemaPhoreDemo {
    public static void main(String[] args) {
        //    new Semaphore(5,true);
        //模拟5张桌子，这里使用公平锁，前五个客人可以先进去吃
        Semaphore semaphore = new Semaphore(5,true);

        //7 吃饭的客人

        for(int i = 0; i < 7; i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 进去吃饭");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"\t 吃完离开");
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

}