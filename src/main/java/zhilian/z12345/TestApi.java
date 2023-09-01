package zhilian.z12345;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hailang.zhang
 * @since 2023-08-10
 */
public class TestApi {

    public static void main(String[] args) throws IOException {
        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                5,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100));
    }
}