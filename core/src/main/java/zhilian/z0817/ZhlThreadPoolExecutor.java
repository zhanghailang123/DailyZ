package zhilian.z0817;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.stream.IntStream;

/**
 * @description: 最简单的一个线程池的实现
 * @author: zhanghailang
 * @date: 2021/8/17 0017 23:09
 */
@Slf4j
public class ZhlThreadPoolExecutor {

    BlockingDeque<Runnable> taskQueue;
    List<ZhlThread> threads;

    public ZhlThreadPoolExecutor(BlockingDeque<Runnable> taskQueue, int threadSize) {
        this.taskQueue = taskQueue;
        this.threads = new ArrayList<>(threadSize);
        IntStream.rangeClosed(1,threadSize).forEach( i ->{
            ZhlThread thread = new ZhlThread("zhl-task-Thread-" + i);
            thread.start();
            threads.add(thread);
        });
    }



    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    class ZhlThread extends Thread{

        public ZhlThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true){
                Runnable task = null;
                try {
                    task = taskQueue.take();
                } catch (InterruptedException e) {
                    log.error("获取任务失败",e);
                }
                task.run();
            }
        }
    }

    public static void main(String[] args) {

    }
 }