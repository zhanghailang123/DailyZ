package zhilian.proceeen.wrapper.instance;

import zhilian.proceeen.processor.Processor;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
public class ReflectNodeInstanceCreator implements ProcessorInstanceCreator {

    @Override
    public Processor newInstance(String className, String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        Object o = clazz.newInstance();
        if (!(o instanceof Processor)) {
            throw new RuntimeException();
        }
        Processor processor = (Processor) o;
        processor.setName(name);
        return processor;
    }
}