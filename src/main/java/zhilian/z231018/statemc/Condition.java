package zhilian.z231018.statemc;

/**
 * @author hailang.zhang
 * @since 2023-10-31
 */
public interface Condition<C> {

    boolean isSatisfied(C context);

    default String name() {
        return this.getClass().getSimpleName();
    }
}
