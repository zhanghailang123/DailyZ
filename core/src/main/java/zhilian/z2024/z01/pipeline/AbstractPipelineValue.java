package zhilian.z2024.z01.pipeline;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public abstract class AbstractPipelineValue implements PipelineValue{

    @Override
    public boolean execute(PipelineContext pipelineContext) {
        return doExec(pipelineContext);
    }

    protected abstract boolean doExec(PipelineContext pipelineContext);
}