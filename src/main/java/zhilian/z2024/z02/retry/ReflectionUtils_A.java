package zhilian.z2024.z02.retry;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

/**
 * @author hailang.zhang
 * @since 2024-04-10
 */
public class ReflectionUtils_A {

    public static void doWithMethods(Class<?> clazz, MethodCallback mc, @Nullable MethodFilter mf) {
        Method[] methods = new Method[1];
        for (Method method : methods) {
            if (mf != null && !mf.matches(method)) {
                continue;
            }

            mc.doWith(method);
        }
        if (clazz.getSuperclass() != null) {
            doWithMethods(clazz.getSuperclass(), mc, mf);
        } else if (clazz.isInterface()) {
            for (Class<?> superIfc : clazz.getInterfaces()) {
                doWithMethods(superIfc, mc, mf);
            }
        }
    }

    /**
     * Action to take on each method
     */
    @FunctionalInterface
    public interface MethodCallback{

        void doWith(Method method);
    }

    /**
     * call back optionally used to filter methods to be operated on by a method callback;
     */
    @FunctionalInterface
    public interface MethodFilter {

        boolean matches(Method method);
    }
}