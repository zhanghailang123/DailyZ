package zhilian.proceeen.wrapper;

import lombok.extern.slf4j.Slf4j;
import zhilian.proceeen.process.ProcessContext;
import zhilian.proceeen.process.ProcessorDefinition;
import zhilian.proceeen.wrapper.instance.ProcessorInstanceCreator;
import zhilian.proceeen.wrapper.instance.ReflectNodeInstanceCreator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
@Slf4j
public final class ProcessContextFactory {
    private static final ProcessorInstanceCreator DEFAULT_INSTANCE_CREATOR = new ReflectNodeInstanceCreator();
    private List<ProcessModel> modelList;
    private final Map<String, ProcessorDefinition> processDefinitionMap = new ConcurrentHashMap<>();
    private final ProcessorInstanceCreator instanceCreator;

    public ProcessContextFactory(List<ProcessModel> modelList) {
        this(modelList, DEFAULT_INSTANCE_CREATOR);
    }

    public ProcessContextFactory(List<ProcessModel> modelList, ProcessorInstanceCreator instanceCreator) {
        this.modelList = modelList;
        this.instanceCreator = instanceCreator;
    }

    private void init() {
        for (ProcessModel processModel : modelList) {
            processModel.check();
        }
        for (ProcessModel processModel : modelList) {
            ProcessorDefinition processorDefinition = processModel.build(instanceCreator);
            processDefinitionMap.put(processorDefinition.getName(), processorDefinition);
        }
    }

    public ProcessContext getContext(String name) {
        ProcessorDefinition definition = processDefinitionMap.get(name);
        if (definition == null) {
            throw new IllegalArgumentException("流程不存在");
        }
        return new ProcessContext(definition);
    }

    public void refresh(List<ProcessModel> modelList) {
        synchronized (this) {
            this.modelList = modelList;
            init();
        }
    }
}