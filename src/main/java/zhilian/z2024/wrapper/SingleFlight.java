package zhilian.z2024.wrapper;

/**
 * @author hailang.zhang
 * @since 2024-06-14
 */
import java.util.concurrent.*;

public class SingleFlight {
    private final ConcurrentHashMap<String, Future<Object>> cache = new ConcurrentHashMap<>();

    public Object get(String key, Callable<Object> loader) throws Exception {
        while (true) {
            Future<Object> future = cache.get(key);
            if (future == null) {
                Callable<Object> callable = () -> {
                    try {
                        return loader.call();
                    } finally {
                        cache.remove(key);
                    }
                };
                FutureTask<Object> futureTask = new FutureTask<>(callable);
                future = cache.putIfAbsent(key, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 执行加载任务
                }
            }
            try {
                return future.get(); // 等待结果
            } catch (CancellationException e) {
                cache.remove(key, future);
            } catch (ExecutionException e) {
                throw new Exception(e.getCause());
            }
        }
    }

    public static void main(String[] args) {
        SingleFlight singleFlight = new SingleFlight();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<Object> loader = singleFlight::loadFromDB;

        Runnable task = () -> {
            try {
                Object result = singleFlight.get("myKey", loader);
                System.out.println(Thread.currentThread().getName() + ": " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        executor.shutdown();
    }

    private String loadFromDB() throws InterruptedException {
        System.out.println("请求到数据库了");
        // 模拟加载数据
        Thread.sleep(2000);
        return "Loaded Data";
    }
}