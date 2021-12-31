package zhilian.z0922;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/9/22 0022 22:05
 */
public class TestCopyOnWrite {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//        new CopyOnWriteArrayList<>()
//        CopyOnWriteArrayList.class.g
        Thread thread = new Thread();

        int i = 1;
        i ++;
        System.out.println(i);

        ThreadLocal<String> local = ThreadLocal.withInitial(() -> "zzz");
    }
}