package zhilian.z1228;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import zhilian.z1215.DeepStuThreadLocal;

/**
 * @description: 偏向锁，对象内存布局等
 * @author: zhanghailang
 * @date: 2021/12/28 0028 21:56
 */
@Slf4j
public class TestJOL {

    public static void main(String[] args) {
        DeepStuThreadLocal o = new DeepStuThreadLocal();
        o.setA("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        log.info("未进入同步块，MarkWord 为: ");
        log.info(ClassLayout.parseInstance(o).toPrintable());

        //持久化和可靠性提升的交换条件是应用吞吐量的降低
        //持久化和可靠性提升的交换条件是应用吞吐量的降低
        //持久化和可靠性提升的交换条件是应用吞吐量的降低

        //传统UNIX实现的内核都设置了内核缓冲区和页高速缓存，大多是磁盘IO都是通过缓冲实现的
        //WAL write ahead logging  redolog : 记录数据页的物理修改 binlog undolog fsync

        //冷静 专注 努力 集中
        //传统UNIX实现的内核都设置了缓冲区或者页高速缓存，大多数的磁盘IO都是通过缓冲实现的 专注
        //write 调用不会等到硬盘IO完成之后才返回 因此如果OS在write调用之后、硬盘同步之前崩溃，则数据可能丢失
        //write 调用不会等到硬盘IO完成之后才返回 因此如果OS在write调用之后、硬盘同步之前崩溃，则数据可能丢失
        //fsync的功能是确保FD所有已修改的内容已经正确的同步到硬盘中，该调用会一直阻塞等待直到设备报告IO完成。
        synchronized (o) {
            log.info("进入同步块，MarkWord 为：");
            log.info(ClassLayout.parseInstance(o).toPrintable());
        }
        //net.ipv4.tcp_tw_reuse 为什么Linux默认是关闭 可以复用Time_Wait的设置


        //自增主键可以让主键索引尽量地保持递增顺序插入，避免了页分裂，因此索引更紧凑
        //自增主键可以让主键索引尽量地保持递增顺序插入，避免了页分裂，因此索引更紧凑
        //雪花算法全局递增的初衷：减少数据库的页分裂
        //DDL操作无法回滚事务，其操作会隐性提交事务
        //在日常开发中，最好不要在事务中混用DDL语句，DDL语句和DML语句分开写
        //写操作并不直接对应于状态的修改，而是对应追加一条日志
    }
}