package zhilian.z2024.z02.retry;

/**
 * @author hailang.zhang
 * @since 2024-02-29
 */
public interface RetryCallback <T, E extends Throwable>{

    T doWithRetry(RetryContext context) throws E;


}
