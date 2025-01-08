package zhilian.proceeen.wrapper.instance;

import org.springframework.stereotype.Component;
import zhilian.proceeen.processor.Processor;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
@Component
public class SpringBeanInstanceCreator implements ProcessorInstanceCreator {

    @Override
    public Processor newInstance(String className, String name) {
        Object bean;
        try {
            Class<?> clazz = Class.forName(className);
            bean = SpringContextUtil.getBean(clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (!(bean instanceof Processor)) {
            throw new RuntimeException();
        }
        Processor processor = (Processor) bean;
        processor.setName(name);
        return processor;
    }
}