package zhilian.z0830;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 阻塞线程的一种实现
 * https://mp.weixin.qq.com/s/ddkm9URontQTDax3djfVjQ
 * @author: zhanghailang
 * @date: 2021/8/30 0030 23:28
 */
public class ZhlBlockingQueue {

    /**
     * 队列容器
     */
    private Object[] tab;

    private ReentrantLock reentrantLock = new ReentrantLock();

    private int size;

    private int putIndex;

    /**
     * 读条件
     */
    private Condition notEmpty;
    /**
     * 写条件
     */
    private Condition notFull;

    public ZhlBlockingQueue(int tabCount) {
        if (tabCount <= 0){
            new NullPointerException();
        }
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
    }


    public boolean offer(Object o){
        if (o == null) {
            throw  new NullPointerException();
        }
        reentrantLock.lock();
        try {
            while (size == tab.length){
                System.out.println("队列已满");
                notFull.await();
            }

            tab[putIndex] = o;
            if (++putIndex == tab.length){
                putIndex = 0;
            }
            size ++;
            notEmpty.signal();
            return true;

        } catch (Exception e){

        } finally {
            reentrantLock.unlock();
        }

        return false;
    }
}