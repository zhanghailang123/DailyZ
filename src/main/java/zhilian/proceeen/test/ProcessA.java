package zhilian.proceeen.test;

import zhilian.proceeen.process.ProcessContext;
import zhilian.proceeen.process.ProcessorDefinition;
import zhilian.proceeen.process.ProcessNode;
import zhilian.proceeen.processor.StandardProcessor;

/**
 * @author hailang.zhang
 * @since 2024-03-26
 */
public class ProcessA {

    public static void main(String[] args) {
        ProcessNode nodeA = new ProcessNode();
        ProcessNode nodeB = new ProcessNode();
        ProcessNode nodeC = new ProcessNode();
        ProcessNode nodeD = new ProcessNode();

        nodeA.setProcessor(new StandardProcessor());
        nodeB.setProcessor(new StandardProcessor());
        nodeC.setProcessor(new StandardProcessor());
        nodeD.setProcessor(new StandardProcessor());

        nodeA.addNextNode(nodeB);
        nodeB.addNextNode(nodeC);
        nodeC.addNextNode(nodeD);

        ProcessorDefinition definition = new ProcessorDefinition();
        definition.setFirst(nodeA);

        ProcessContext context = new ProcessContext(definition);
        context.start();
    }
}