package zhilian.z2024.z01.pipeline;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public interface Pipeline {

    /**
     * 执行
     * @param pipelineContext
     * @return
     */
    boolean invoke(PipelineContext pipelineContext);

    boolean addValue(PipelineValue pipelineValue);

    boolean removeValue(PipelineValue pipelineValue);
}
