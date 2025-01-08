package zhilian.customthreadpool;

/**
 * @author hailang.zhang
 * @since 2024-03-22
 */
public class CustomThreadPoolExecutor {

    public final class Worker extends Thread{

        private Runnable task;

        private Thread thread;

        private boolean isNewTask;

        public Worker(Runnable task, boolean isNewTask) {
            this.task = task;
            thread = this;
            this.isNewTask = isNewTask;
        }

        public void startTask() {
            thread.start();
        }

        public void close() {
            thread.interrupt();
        }
    }
}