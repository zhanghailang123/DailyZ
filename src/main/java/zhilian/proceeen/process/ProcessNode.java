package zhilian.proceeen.process;

import lombok.Data;
import zhilian.proceeen.processor.Processor;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个流程节点
 * @author hailang.zhang
 * @since 2024-03-26
 */
@Data
public class ProcessNode {

    private String nodeName;

    private Processor processor;

    private boolean isFirst;

    private Map<String, ProcessNode> nextNodes = new HashMap<>();

    public void addNextNode(ProcessNode nextNode) {
        nextNodes.put(nextNode.getNodeName(), nextNode);
    }

}