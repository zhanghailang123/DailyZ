package zhilian.z230426;

import java.time.Instant;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试栈上分配的场景
 * @author hailang.zhang
 * @since 2023-04-26
 */
public class TestStackAllocated {

    public static void main(String[] args) {

        //如何判断线程池中所有的任务都执行完毕了
        ThreadPoolExecutor executor =  new ThreadPoolExecutor(
                5,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " 执行完了第" + finalI + "个任务") ;
            });

        }

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
        //Focus on where you are doing

        while (executor.getTaskCount() != executor.getCompletedTaskCount()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("所有任务数:" + executor.getTaskCount() + "；已完成任务数" + executor.getCompletedTaskCount());
        }

        System.out.println("最后已完成的任务数：" + executor.getCompletedTaskCount());


        //3.使用countDownlatch 需要明确知道多少个任务

        //4.手动维护一个线程安全的计数器

        //5.使用future  使用future.isDone()

    }

    private static void allocate() {
        TestStackDO a = new TestStackDO("111");
    }
}