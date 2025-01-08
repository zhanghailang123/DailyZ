package zhilian.proceeen.wrapper.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import zhilian.proceeen.wrapper.ProcessContextFactory;
import zhilian.proceeen.wrapper.ProcessModel;
import zhilian.proceeen.wrapper.parse.ClassPathXmlProcessParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-03-28
 */
@Slf4j
public class ProcessNodeRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        try {
            String configFile = (String) annotationMetadata.getAnnotationAttributes(EnableProcessEngine.class.getName()).get("value");
            //1.解析得到流程
            ClassPathXmlProcessParser classPathXmlProcessParser = new ClassPathXmlProcessParser(configFile);
            List<ProcessModel> processModelList = classPathXmlProcessParser.parse();

            //2. 注册ProcessContextFactory
            BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(ProcessContextFactory.class);
            bdb.addConstructorArgValue(new ArrayList<>(processModelList));
            bdb.addConstructorArgReference("springBeanInstanceCreator");
            registry.registerBeanDefinition(ProcessContextFactory.class.getName(), bdb.getBeanDefinition());
        } catch (Exception e) {
            log.error("注册factory失败", e);
        }

    }
}