package zhilian.z0807;

import java.lang.annotation.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/7 0007 22:14
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {
    int order() default -1;
    int length() default -1;
    String type() default "";
}