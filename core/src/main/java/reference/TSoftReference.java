package reference;

import java.lang.ref.SoftReference;

/**
 * @description: 软引用
 * @author: zhanghailang
 * @date: 2020/12/11 0011 23:10
 */
public class TSoftReference {
    public static void main(String[] args) {
        //构建一个软引用
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        /**
         * 可以设置当前类运行堆内存的大小，RUN --》 run ==》 找到当前类 ====》  -Xmx20m
         */
        //再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        //强引用
//        byte[] b = new byte[1024*1024*12];
        //测试下假如说都是新建的对象也是软引用
        SoftReference<byte[]> m2 = new SoftReference<>(new byte[1024*1024*12]);
        System.out.println(m.get());
        System.out.println(m2.get());
    }
}