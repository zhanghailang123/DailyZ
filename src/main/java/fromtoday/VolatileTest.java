package fromtoday;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/3/16 0016 22:03
 */
public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Thread.activeCount :::" + Thread.activeCount());
        Thread.ofVirtual().start(() -> {
            System.out.println(Thread.currentThread());
        }).join();
    }
}