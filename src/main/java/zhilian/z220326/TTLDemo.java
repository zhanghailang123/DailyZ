package zhilian.z220326;

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
    private static final ThreadLocal<Map<String,String>> contextHolder = ThreadLocal.withInitial(() -> {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","b");
        return map;
    });

    public static void main(String[] args) {
//        final Map<String,String> context = getContext();

//        Map<String,String> contextCopy = new HashMap<>(context);
        System.out.println(Thread.currentThread().getName());
        Runnable asyncLogic = () -> {
            System.out.println(contextHolder.get());
            System.out.println(Thread.currentThread().getName());
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(asyncLogic);
//        new Thread(asyncLogic).start();
    }


    //    private static Map<String,String> getContext() {
//        return contextHolder.get();
//    }
//    public static void main(String[] args) {
//        // 异步处理线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        int requestNum = 3;
//        int currentRequest = 0;
//        while (currentRequest++ < requestNum) {
//            // 请求前初始化traceContext
//            Trace.init();
//
//            System.out.println(String.format("处理开始,请求号=%s, traceId=%d", currentRequest, Trace.id()));
//
//            // 异步处理，传递traceContext
//            int finalCurrentRequest = currentRequest;
//            executorService.submit(() -> {
//                System.out.println(String.format("异步场景下，请求号=%s, traceId=%d", finalCurrentRequest, Trace.id()));
//            });
//
//            // 请求处理结束清理traceContext
//            System.out.println(String.format("处理结束,请求号=%s, traceId=%d", currentRequest, Trace.id()));
//            Trace.destroy();
//        }
//    }
//
//    static class Trace {
//        // trace上下文，存储traceId
//        private static ThreadLocal<Long> traceContext = new ThreadLocal<>();
//        private static final Random random = new Random();
//
//        public static void init() {
//            // 随机产生traceId
//            traceContext.set(Math.abs(random.nextLong()));
//        }
//
//        public static Long id() {
//            return traceContext.get();
//        }
//
//        public static void destroy() {
//            traceContext.remove();
//        }
//
//    }
}