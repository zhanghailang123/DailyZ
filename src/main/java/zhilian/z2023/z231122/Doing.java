package zhilian.z2023.z231122;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hailang.zhang
 * @since 2023-11-22
 */
public class Doing {

    @Transactional(rollbackFor = Exception.class)
    public void doRecord() {
        ReentrantLock lock = new ReentrantLock();
        Queue<TreeMap> queue = new LinkedList<>();
        ArrayList list = new ArrayList();

        try {
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}