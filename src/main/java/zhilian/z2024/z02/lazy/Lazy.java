package zhilian.z2024.z02.lazy;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 惰性计算的学习
 * @author hailang.zhang
 * @since 2024-02-22
 */
public class Lazy<T> implements Supplier<T> {

    private Supplier<? extends T> supplier;

    private T value;

    public Lazy(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    public Lazy() {
    }

    public static <T> Lazy<T> of(Supplier<? extends T> supplier) {
        return new Lazy<>(supplier);
    }

    public static <T> Lazy<T> ofNullable(Supplier<? extends T> supplier) {
        if (supplier == null) {
            return new Lazy<>();
        }
        return new Lazy<>(supplier);
    }

    public <S> Lazy<S> map(Function<? super T, ? extends S> function) {
        return Lazy.of(() -> function.apply(this.get()));
    }

    public <S> Lazy<S> flatMap(Function<? super T, Lazy<? extends S>> function) {
        return Lazy.of(() -> function.apply(this.get()).get());
    }

    @Override
    public T get() {
        if (value == null) {
            T newValue = supplier.get();
            if (newValue == null) {
                throw new IllegalStateException("can not be null");
            }
            value = newValue;
        }
        return value;
    }

    public static void main(String[] args) {
        Lazy<Integer> a = Lazy.of(() -> 10 + 1);
        int b = a.get() + 1;
        int c = a.get();

        System.out.println(b);
        System.out.println(c);

        Optional.ofNullable(a);
    }
}