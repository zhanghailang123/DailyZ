package zhilian.z220326;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @description: 优先级队列测试
 * @author: zhanghailang
 * @date: 2022/3/26 0026 16:27
 */
public class PriorityTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(7);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(100));
        }

//        for (int a : queue) {
//            System.out.println(a);
//        }

//        for (int i = 0; i < 7; i++) {
//            System.out.println(queue.poll());
//        }

//        System.out.println(DateUtil.dayOfWeekEnum(new Date()).getValue());
//        System.out.println(DateUtil.yesterday().toString("yyyy-MM-dd"));
        System.out.println(DateUtil.lastWeek().toString("yyyy-MM-dd"));
        System.out.println(DateUtil.formatDate(new Date()));
    }
}