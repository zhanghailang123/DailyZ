package zhilian.z2023.z230426;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试栈上分配的场景
 * @author hailang.zhang
 * @since 2023-04-26
 */
public class TestStackAllocated {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor =  new ThreadPoolExecutor(
                5,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            executor.execute(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                System.out.println(Thread.currentThread().getName() + " 执行完了第" + finalI + "个任务") ;
//            });
//
//        }

        //1.方式一 通过终止线程池 判断线程池中是否终止 来判断任务是否执行完毕 但是一般线程池也不会终止，不推荐使用
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("线程还在执行中");
//            long taskCount = executor.getCompletedTaskCount();
//            System.out.println("完成的任务数:" + taskCount);
//        }

//        try {
//            executor.awaitTermination(1, TimeUnit.SECONDS);
//            long taskCount = executor.getCompletedTaskCount();
//            System.out.println("完成的任务数:" + taskCount);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //Focus on where you are doing

//        while (executor.getTaskCount() != executor.getCompletedTaskCount()) {
//            System.out.println("所有任务数:" + executor.getTaskCount() + "；已完成任务数" + executor.getCompletedTaskCount());
//        }
//
//        System.out.println("最后已完成的任务数：" + executor.getCompletedTaskCount());



        //在业务线程池正在执行上面10条任务的时候，再新提交15条任务，而我们只关注这15条任务该怎么做呢
//        CountDownLatch latch = new CountDownLatch(15);
//        for (int i = 0; i < 15; i++) {
//            int finalI = i;
//            executor.execute(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("【新提交的任务】" + Thread.currentThread().getName() + " 执行完了第" + finalI + "个任务") ;
//                latch.countDown();
//            });
//        }
//        latch.await();
//        System.out.println("新提交的任务执行完成啦");
//        System.out.println("最后已完成的总计任务数：" + executor.getCompletedTaskCount());

        //4.手动维护一个线程安全的计数器
//        AtomicInteger count = new AtomicInteger(0);
//        for (int i = 0; i < 10; i++) {
//            executor.execute(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(Thread.currentThread().getName() + " 执行完了第" + count.getAndIncrement() + "个任务") ;
//            });
//
//        }
//        while (count.get() < 10) {
//            System.out.println("任务未执行完，什么也不做");
//            TimeUnit.MILLISECONDS.sleep(100);
//        }
//        System.out.println("最后已完成的总计任务数：" + count.get() + "=====" + executor.getCompletedTaskCount());
        //5.使用future  使用future.isDone()

        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<Boolean> future = executor.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " 执行完了第" + finalI + "个任务") ;
                return Boolean.TRUE;
            });
            futures.add(future);
        }

        for (Future f : futures) {
            f.get();
        }
        System.out.println("最后已完成的总计任务数：" + executor.getCompletedTaskCount());
    }

    private static void allocate() {
        TestStackDO a = new TestStackDO("111");
    }
}