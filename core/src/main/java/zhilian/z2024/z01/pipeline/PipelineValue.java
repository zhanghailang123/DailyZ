package zhilian.z2024.z01.pipeline;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public interface PipelineValue {

    /**
     * 节点执行
     * @param pipelineContext
     * @return
     */
    boolean execute(PipelineContext pipelineContext);
}
