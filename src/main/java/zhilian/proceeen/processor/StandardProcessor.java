package zhilian.proceeen.processor;

import zhilian.proceeen.process.ProcessContext;

/**
 * @author hailang.zhang
 * @since 2024-03-26
 */
public class StandardProcessor extends AbstractProcessor{

    @Override
    public void processInternal(ProcessContext processContext) {
        System.out.println("执行到一个标准节点了");
    }
}