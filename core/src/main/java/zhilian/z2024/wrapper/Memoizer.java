package zhilian.z2024.wrapper;

import com.zhanghl.first.pattern.wrapper.Computable;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author hailang.zhang
 * @since 2024-06-24
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final zhilian.z2024.wrapper.Computable<A, V> c;

    public Memoizer(zhilian.z2024.wrapper.Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        while (true) {
            Future<V> future = cache.get(arg);
            if (future == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<V>(eval);
                future = cache.putIfAbsent(arg, ft);
                if (future == null) {
                    future = ft;
                    ft.run();
                }
            }
            return future.get();
        }
    }
}