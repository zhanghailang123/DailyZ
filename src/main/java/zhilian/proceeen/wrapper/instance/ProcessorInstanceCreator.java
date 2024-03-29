package zhilian.proceeen.wrapper.instance;

import zhilian.proceeen.processor.Processor;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
public interface ProcessorInstanceCreator {

    /**
     * 创建实例
     * @param className className
     * @param name name
     * @return processor
     */
    Processor newInstance(String className, String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
