package zhilian.z220326;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/4/15 9:24
 */
public class TTLDemo3 {


    public static void main(String[] args) {
        // 异步处理线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(Trace.id());
        executorService.submit(() -> {
            System.out.println(String.format("异步场景下，请求号=%s, traceId=%d", 11, Trace.id()));
        });


    }

    static class Trace {
        // trace上下文，存储traceId
//        private static ThreadLocal<Long> traceContext = new ThreadLocal<>();
        private static ThreadLocal<Long> traceContext = new ThreadLocal<>();
        private static final Random random = new Random();

        static {
            traceContext.set(Math.abs(random.nextLong()));
        }
        public static Long id() {
            return traceContext.get();
        }

        public static void destroy() {
            traceContext.remove();
        }

    }
}