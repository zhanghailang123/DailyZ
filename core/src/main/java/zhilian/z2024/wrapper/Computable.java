package zhilian.z2024.wrapper;

import org.checkerframework.checker.units.qual.A;

/**
 * @author hailang.zhang
 * @since 2024-06-24
 */
public interface Computable<A, V> {

    V compute(A arg);
}
