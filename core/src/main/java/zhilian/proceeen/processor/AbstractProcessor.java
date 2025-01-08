package zhilian.proceeen.processor;

/**
 * 定义process
 * @author hailang.zhang
 * @since 2024-03-26
 */
public abstract class AbstractProcessor implements Processor {

    @Override
    public void process(ProcessContext processContext) {
        beforeProcess(processContext);
        processInternal(processContext);
        afterProcess(processContext);
    }

    public void beforeProcess(ProcessContext processContext) {

    }

    public abstract void processInternal(ProcessContext processContext);

    public void afterProcess(ProcessContext processContext) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void caughtException(ProcessContext context, Throwable throwable) {
        //no-op
    }
}