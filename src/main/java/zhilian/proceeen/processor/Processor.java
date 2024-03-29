package zhilian.proceeen.processor;

import zhilian.proceeen.process.ProcessContext;

/**
 * @author hailang.zhang
 * @since 2024-03-26
 */
public interface Processor {

    void process(ProcessContext processContext);

    void setName(String name);
}