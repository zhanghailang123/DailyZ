package zhilian.z0807;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPI {
    String desc() default "";
    String url() default "";
}
