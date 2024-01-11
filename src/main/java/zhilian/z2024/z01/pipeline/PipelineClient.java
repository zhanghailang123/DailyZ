package zhilian.z2024.z01.pipeline;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public class PipelineClient {

    public static void main(String[] args) {
        Pipeline pipeline = new StandardPipeline();

        PipelineValue pipelineValue = new GraySwitchValue();
        PipelineValue pipelineValue1 = new ForTestValue();

        PipelineContext pipelineContext = new StandardPipelineContext();

        pipeline.addValue(pipelineValue);
        pipeline.addValue(pipelineValue1);

        pipeline.invoke(pipelineContext);
    }
}