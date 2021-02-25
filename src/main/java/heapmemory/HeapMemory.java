package heapmemory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 对象头 堆内存分配
 * @author: zhanghailang
 * @date: 2021/2/25 0025 21:47
 */
public class HeapMemory {
    /**
     * 对象头:
     *      MarkWorld
     *              HashCode
     *              GC分代年龄
     *              锁标记
     *              偏向锁标记
     *      ClassPointer
     *          对象指向它所属的类元信息地址
     *      Length
     *          数组持有 只有数组对象保存了这部分数据
     * 实例数据
     *      包含了对象的所有成员变量
     * 对齐填充
     *      保证对象的大小为8字节的整数倍
     *      如果没有达到就填充到8字节的整数倍
     * @param args
     */
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}