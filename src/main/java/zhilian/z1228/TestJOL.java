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

        synchronized (o) {
            log.info("进入同步块，MarkWord 为：");
            log.info(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}