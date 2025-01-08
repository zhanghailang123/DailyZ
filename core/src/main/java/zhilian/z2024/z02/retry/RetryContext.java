package zhilian.z2024.z02.retry;

import org.springframework.core.AttributeAccessor;

/**
 * @author hailang.zhang
 * @since 2024-02-29
 */
public interface RetryContext extends AttributeAccessor {

    String NAME = "context.name";

    int getRetryCount();
}
