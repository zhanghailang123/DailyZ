package zhilian.proceeen.wrapper;

import zhilian.proceeen.process.ProcessorDefinition;
import zhilian.proceeen.wrapper.instance.ProcessorInstanceCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
public class ProcessModel {
    private String name;
    private final Map<String, ProcessNodeModel> nodes = new HashMap<>();

    public void addNode(ProcessNodeModel node) {
        if (nodes.containsKey(node.getName())) {
            throw new IllegalStateException("");
        }
        nodes.put(node.getName(), node);
    }

    public void check() {
        int startNode = 0;
        for (ProcessNodeModel processNodeModel : nodes.values()) {
            String className = processNodeModel.getClassName();
            try {
                Class<?> aClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String nextNode = processNodeModel.getNextNodeName();
            if (nextNode != null) {
                String[] nextNodes = nextNode.split(",");
                for (String nodeName : nextNodes) {
                    if (!nodes.containsKey(nodeName)) {
                        throw new RuntimeException();
                    }
                }
            }
            if (processNodeModel.isBegin()) {
                startNode++;
            }
        }
        if (startNode != 1) {
            throw new IllegalArgumentException("每个流程只能有一个开始节点");
        }
    }

    public ProcessorDefinition build(ProcessorInstanceCreator instanceCreator) {
        return null;
    }
}