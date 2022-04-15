package zhilian.z220326;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:实现了线程池下的ThreadLocal值传递功能
 * @author: zhanghailang
 * @date: 2022/4/13 9:45
 */
public class TTLDemo2 {
//    private final static InheritableThreadLocal<String> inherited = InheritableThreadLocal.withInitial(() -> {return"zzz";}));
    private final static TransmittableThreadLocal<String> content1 = new TransmittableThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "zzzz";
        }
    };
    private final static TransmittableThreadLocal<Node> content2 = new TransmittableThreadLocal<Node>() {
        @Override
        public Node copy(Node parentValue) {
            return new Node(parentValue.id);
        }

        @Override
        protected Node initialValue() {
            return new Node("1");
        }
    };

    private static final ExecutorService executor = TtlExecutors.getTtlExecutorService(Executors.newCachedThreadPool());

    public static void main(String[] args) {
        Runnable runAsync = () -> {
            System.out.println(content1.get());
            System.out.println(content2.get());
        };

        executor.submit(runAsync);

    }
    public static class Node {
        final String id;

        public Node(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node: " + id;
        }
    }
}