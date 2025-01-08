package zhilian.z2024.z01.pipeline;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public class GraySwitchValue extends AbstractPipelineValue {

    @Override
    protected boolean doExec(PipelineContext pipelineContext) {
        pipelineContext.set(PipelineContext.FOR_TEST, true);
        return true;
    }
}