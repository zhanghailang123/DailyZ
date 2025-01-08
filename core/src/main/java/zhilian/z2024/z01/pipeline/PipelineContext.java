package zhilian.z2024.z01.pipeline;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public interface PipelineContext {

    String FOR_TEST = "forTest";

    /**
     * 设置
     * @param contextKey
     * @param contextValue
     */
    void set(String contextKey, Object contextValue);

    /**
     * 获取值
     * @param contextKey
     * @return
     */
    Object get(String contextKey);
}
