package zhilian.proceeen.processor;

/**
 * @author hailang.zhang
 * @since 2024-03-26
 */
public interface Processor {

    void process(ProcessContext processContext);

    void setName(String name);

    void caughtException(ProcessContext context, Throwable throwable);
}