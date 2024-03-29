package zhilian.proceeen.processor;

/**
 * @author hailang.zhang
 * @since 2024-03-29
 */
public abstract class RollbackProcessor extends AbstractProcessor{

    /**
     * 回滚操作
     * @param context 上下文
     */
    protected abstract void rollback(ProcessContext context);
}