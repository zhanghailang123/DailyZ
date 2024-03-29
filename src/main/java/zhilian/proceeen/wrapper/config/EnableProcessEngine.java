package zhilian.proceeen.wrapper.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({})
public @interface EnableProcessEngine {

    /**
     * 配置文件名称
     */
    String value();
}