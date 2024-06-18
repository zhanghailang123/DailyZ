package zhilian.z2024.wrapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author hailang.zhang
 * @since 2024-06-17
 */
public class CacheExpired {

    //    private final static JedisPool jedisPool = new JedisPool("localhost", 6379);

    public static void main(String[] args) {
        //        //初始化缓存
        //        try (Jedis jedis = jedisPool.getResource()) {
        //            jedis.psetex("key", 300, "value");
        //        }
        CacheExpired cacheExpired = new CacheExpired();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> result = executorService.submit(() -> {
                //                //先从缓存中获取
                //                String s = cacheExpired.loadFromCache();
                //                if (s != null) {
                //                    return s;
                //                }
                //全部从DB中获取。
                String s = cacheExpired.singleFlight();
                return s;
            });
            futures.add(result);
        }

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //存储正在进行或者已完成的请求，如果多个请求同时进来，可保证只有一个请求回去查询DB
    private final ConcurrentHashMap<String, Future<String>> cache = new ConcurrentHashMap<>();

    public String singleFlight() throws Exception {
        while (true) {
            Future<String> future = cache.get("key");
            if (future == null) {
                Callable<String> callable = () -> {
                    loadFromDB();
                    return "执行完成";
                };
                FutureTask<String> futureTask = new FutureTask<>(callable);
                future = cache.putIfAbsent("key", futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 执行加载任务
                }
            }
            try {
                return future.get(); // 等待结果
            } catch (CancellationException e) {
                cache.remove("key", future);
                System.out.println(e);
            } catch (ExecutionException e) {
                throw new Exception(e.getCause());
            }
        }
    }

    public void loadFromDB() {
        try {
            //从db获取数据是个耗时的操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "：从db获取数据成功");
    }
}
