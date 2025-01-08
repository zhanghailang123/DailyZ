package com.zhanghl.first.z220207.bytedance;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hailang.zhang
 * @since 2023-06-29
 */
public class FutureTaskBugTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ZhlThreadFactory("zhl"),
                new MyRejectedPolicy());
        while (true) {
            TimeUnit.SECONDS.sleep(1);

            new Thread(() -> {
                ArrayList<Future<Integer>> futures = new ArrayList<>();
                int num = 5;

                for (int i = 0; i < num; i ++) {
                    int finalI = i;
                   Future<Integer> future = executor.submit(() -> {
                        System.out.println("Thread.CurrentThread().getName() = " + Thread.currentThread().getName());
                        return finalI * 10;
                    });
                   futures.add(future);
                }

                for (Future<Integer> future : futures) {
                    try {
                        Integer integer = future.get();
                        System.out.println(integer);
                        System.out.println("future.get() = " + integer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    static class ZhlThreadFactory implements ThreadFactory{

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final String threadFactoryName;

        public String getThreadFactoryName() {
            return threadFactoryName;
        }
        public ZhlThreadFactory(String threadFactoryName) {
            SecurityManager s = System.getSecurityManager();
            this.group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = threadFactoryName + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
            this.threadFactoryName = threadFactoryName;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    public static class MyRejectedPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (executor.getThreadFactory() instanceof ZhlThreadFactory) {
                ZhlThreadFactory threadFactory = (ZhlThreadFactory) executor.getThreadFactory();
                if ("product".equals(threadFactory.getThreadFactoryName())) {
                    System.out.println("线程池有任务被拒绝了，请关注");
                }
            }
        }
    }
}