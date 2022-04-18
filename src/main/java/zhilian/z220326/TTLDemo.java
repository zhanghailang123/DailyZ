package zhilian.z220326;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 阿里开源的TTL测试使用
 * 异步执行上下文的传递
 * 透明/自动完成所有异步执行上下文的可定制、规范化的捕捉和传递。
 * @author: zhanghailang
 * @date: 2022/4/10 0010 20:18
 */
public class TTLDemo {


    public static void main(String[] args) {
//        Runnable asyncLogic = () -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(get());
//            System.out.println(Thread.currentThread().getName());
//        };
        ThreadLocal<Map<String, String>> contextHolder = new ThreadLocal<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "b");
        contextHolder.set(map);
        System.out.println(contextHolder.get());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(contextHolder.get());
            System.out.println(Thread.currentThread().getName());
        });
//        new Thread(asyncLogic).start();

        System.out.println(DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_FORMAT));
        System.out.println(DateUtil.formatDateTime(new Date()));
    }

}