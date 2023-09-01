package zhilian.z230824;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author zhanghailang
 * @since 2023/8/24 17:51
 **/
public class TestThreadPoolRejectHandler {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("线程池已满, 静默处理什么也不做");
                    }
                });

        ArrayList<Future<String>> futureList = new ArrayList<>();
        while (true) {
            //模拟一个定时任务
            TimeUnit.SECONDS.sleep(1);
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    Future<String> result = executor.submit(() -> {
                        String name = Thread.currentThread().getName();
                        System.out.println(name + "正在执行任务");
                        return "zhl";
                    });
                    futureList.add(result);
                }
                for (Future<String> result : futureList) {
                    try {
                        String s = result.get();
                        System.out.println("输出结果" + s);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            ).start();


        }
    }
}
