package zhilian.proceeen.processor;

import lombok.extern.slf4j.Slf4j;
import zhilian.proceeen.process.ProcessNode;
import zhilian.proceeen.process.ProcessorDefinition;
import zhilian.proceeen.processor.Processor;
import zhilian.proceeen.processor.RollbackProcessor;

import java.util.Stack;

/**
 * @author hailang.zhang
 * @since 2024-03-26
 */
@Slf4j
public class ProcessContext {

    private final ProcessorDefinition processorDefinition;
    private final Stack<RollbackProcessor> rollbackProcessors = new Stack<>();

    public ProcessContext(ProcessorDefinition processorDefinition) {this.processorDefinition = processorDefinition;}

    public void start() {
        ProcessNode first = this.processorDefinition.getFirst();
        process(first);
    }

    private void process(ProcessNode node) {
        if (node == null) {
            return;
        }
        Processor processor = node.getProcessor();

        try {
            if (processor instanceof RollbackProcessor) {
                rollbackProcessors.push((RollbackProcessor) processor);
            }
        } catch (Exception e) {
            RollbackProcessor rollbackProcessor;
            while (!rollbackProcessors.empty()) {
                rollbackProcessor = rollbackProcessors.pop();
                try {
                    rollbackProcessor.rollback(this);
                } catch (Exception e1) {
                    log.error("出现回滚异常");
                }
            }
        }
        processor.process(this);


        processor.process(this);
        ProcessNode next = null;
        if (!node.getNextNodes().isEmpty()) {
            next = node.getNextNodes().values().stream().findAny().get();
        }
        process(next);
    }
}