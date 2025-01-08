package zhilian.z2024.z02.queue;

/**
 * 实现一个简单的并发有界队列
 * @author hailang.zhang
 * @since 2024-02-22
 */
public interface Queue {

    boolean offer(Object obj) throws InterruptedException;

    Object poll() throws InterruptedException;
}
