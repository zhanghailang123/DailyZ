package fromtoday;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/3/16 0016 22:03
 */
public class VolatileTest {
    public static void main(String[] args) {
//        System.out.println("Thread.activeCount :::" + Thread.activeCount());
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println("111");
    }
}