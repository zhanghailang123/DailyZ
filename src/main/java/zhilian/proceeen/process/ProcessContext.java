package zhilian.proceeen.process;

/**
 * @author hailang.zhang
 * @since 2024-03-26
 */
public class ProcessContext {

    private final ProcessorDefinition processorDefinition;

    public ProcessContext(ProcessorDefinition processorDefinition) {this.processorDefinition = processorDefinition;}

    public void start() {
        ProcessNode first = this.processorDefinition.getFirst();
        process(first);
    }

    private void process(ProcessNode first) {
        if (first == null) {
            return;
        }
        first.getProcessor().process(this);
        ProcessNode next = null;
        if (!first.getNextNodes().isEmpty()) {
            next = first.getNextNodes().values().stream().findAny().get();
        }
        process(next);
    }
}