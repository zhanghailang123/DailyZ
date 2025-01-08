package main.java.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 虚引用
 * @author: zhanghailang
 * @date: 2020/12/12 0012 00:09
 */
public class TPhanTomReference {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<reference.Re> QUEUE = new ReferenceQueue<>();
    public static void main(String[] args) {
        PhantomReference<reference.Re> re = new PhantomReference<>(new reference.Re(),QUEUE);
        //进来就对虚引用进行get这时候是获取不到值的
        System.out.println(re.get());
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        new Thread(() ->{
            while (true){
                LIST.add(new byte[1024 * 1024]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(re.get());

            }
        }).start();

        //垃圾回收线程

        new Thread(() ->{
            while (true){
                Reference<? extends reference.Re> poll = QUEUE.poll();
            }
        }).start();
    }
}