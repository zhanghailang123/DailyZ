package zhilian.z2024.wrapper;

import zhilian.z2023.z220326.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-06-14
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.*;

public class SingleFlightWithRedis {
    private final JedisPool jedisPool = new JedisPool("localhost", 6379);
    private final ConcurrentHashMap<String, Future<Object>> loadingCache = new ConcurrentHashMap<>();

    public Object get(String key, Callable<Object> loader) throws Exception {
        try (Jedis jedis = jedisPool.getResource()) {
            String cachedValue = jedis.get(key);
            if (cachedValue != null) {
                return cachedValue;
            }
        }

        while (true) {
            Future<Object> future = loadingCache.get(key);
            if (future == null) {
                Callable<Object> callable = () -> {
                    Object value = loader.call();
                    try (Jedis jedis = jedisPool.getResource()) {
                        jedis.set(key, value.toString()); // 这里假设value是一个String，实际情况需要根据数据类型进行处理
                    }
                    return value;
                };
                FutureTask<Object> futureTask = new FutureTask<>(callable);
                future = loadingCache.putIfAbsent(key, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 执行加载任务
                }
            }
            try {
                return future.get(); // 等待结果
            } catch (CancellationException e) {
                loadingCache.remove(key, future);
            } catch (ExecutionException e) {
                throw new Exception(e.getCause());
            }
        }
    }

    public static void main(String[] args) {
        SingleFlightWithRedis singleFlight = new SingleFlightWithRedis();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<Object> loader = () -> {
            // 模拟加载数据
            Thread.sleep(2000);
            return "Loaded Data";
        };

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
}