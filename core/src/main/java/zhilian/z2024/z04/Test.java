package zhilian.z2024.z04;

import cn.hutool.core.util.NumberUtil;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author hailang.zhang
 * @since 2024-05-27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(NumberUtil.decimalFormatMoney(111111111.11111));
    }

    public void test() {
//        //案例一
//        final AtomicBoolean found = new AtomicBoolean(false);
//        this.doWithMethods(Test.class, method -> {
//            if (annotation.annotationType().equals(NotNull.class)) {
//                return true;
//            }
//        });
    }

    public Boolean hashNotNullAnnotation(Class<?> clazz) {
        return clazz.isAnnotationPresent(NotNull.class);
    }

    public Boolean hashAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        //为了案例，此处不使用clazz.isAnnotationPresent(annotationClass)
        for (Annotation annotation : clazz.getAnnotations()) {
            if (annotation.annotationType().equals(NotNull.class)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMethodWithSingleParameterOfType(Method method, String name, Class<?> type) {

        return method.getParameterCount() == 1 //
                && method.getName().equals(name) //
                && method.getParameterTypes()[0].equals(type);
    }

    public List<Method> isMethodWithSingleParameterOfType(Class<?> clazz) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            if (method.getParameterCount() == 1) {
                methods.add(method);
            }
        }
        return methods;
    }


    public void doWithMethods(Class<?> clazz, MethodCallback mc, MethodFilter mf) {
        Method[] methods = clazz.getMethods();
        /**
         * 封装不变
         */
        for (Method method : methods) {
            if (!mf.matches(method)) {
                continue;
            }
            mc.doWith(method);
        }
    }

    /**
     * 抽象可变部分
     */
    @FunctionalInterface
    public interface MethodFilter {

        boolean matches(Method method);
    }

    /**
     * 抽象可变部分
     */
    @FunctionalInterface
    public interface MethodCallback{

        void doWith(Method method);
    }

}