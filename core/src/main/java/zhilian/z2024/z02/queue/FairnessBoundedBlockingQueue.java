package zhilian.z2024.z02.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 公平有界阻塞队列
 * @author hailang.zhang
 * @since 2024-02-22
 */
public class FairnessBoundedBlockingQueue implements Queue{
//
//    //当前大小
//    private int size;

    //容量
    private int capacity;

    protected  Node head;

    protected Node tail;

    protected final Object pollLock = new Object();
    protected int canPollCount;

    protected final Object offerLock = new Object();
    protected int canOfferCount;

    public FairnessBoundedBlockingQueue(int capacity) {
//        this.size = 0;
        this.capacity = capacity;
        this.head = new Node(null);
        this.tail = head;
        this.canPollCount = 0;
        this.canOfferCount = capacity;
    }

    @Override
    public boolean offer(Object obj) throws InterruptedException {
        synchronized (offerLock) {
            while (canOfferCount <= 0) {
                offerLock.wait();
            }

            Node node = new Node(obj);
            tail.next = node;
            tail = node;
            canOfferCount --;
        }

        synchronized (pollLock) {
            ++ canPollCount;
            pollLock.notifyAll();
        }

        return true;
    }

    @Override
    public Object poll() throws InterruptedException {
        Object result = null;
        synchronized (pollLock) {
            while (canPollCount <= 0) {
                pollLock.wait();
                result = head.next.value;
                head.next.value = null;
                head = head.next;
                canPollCount--;
            }
        }

        synchronized (offerLock) {
            canPollCount ++;
            offerLock.notifyAll();
        }
        return result;
    }

    class Node {
        Object value;
        Node next;

        Node(Object obj) {
            this.value = obj;
            next = null;
        }
    }

    public static void main(String[] args) {
        FairnessBoundedBlockingQueue queue2 = new FairnessBoundedBlockingQueue(5);
        new Thread(() -> {
            while (true) {
                try {
                    queue2.offer(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(queue2.poll());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }
}