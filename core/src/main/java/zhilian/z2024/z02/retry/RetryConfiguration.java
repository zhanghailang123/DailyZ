package zhilian.z2024.z02.retry;


import org.springframework.aop.MethodMatcher;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.annotation.AnnotationClassFilter;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author hailang.zhang
 * @since 2024-02-28
 */
public class RetryConfiguration {

    private final class AnnotationClassOrMethodPointcut extends StaticMethodMatcherPointcut {

        private final MethodMatcher methodResolver;

        AnnotationClassOrMethodPointcut(Class<? extends Annotation> annotationType) {
            this.methodResolver = new AnnotationMethodMatcher(annotationType);
            setClassFilter(new AnnotationClassOrMethodFilter(annotationType));
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return getClassFilter().matches(targetClass) || this.methodResolver.matches(method, targetClass);
        }
    }

    private final class AnnotationClassOrMethodFilter extends AnnotationClassFilter {

        private final AnnotationMethodsResolver methodsResolver;

        public AnnotationClassOrMethodFilter(Class<? extends Annotation> annotationType) {
            super(annotationType);
            this.methodsResolver = new AnnotationMethodsResolver(annotationType);
        }

        @Override
        public boolean matches(Class<?> clazz) {
            return super.matches(clazz) || this.methodsResolver.hasAnnotationMethods(clazz);
        }
    }

    private static class AnnotationMethodsResolver {

        private final Class<? extends Annotation> annotationType;

        public AnnotationMethodsResolver(Class<? extends Annotation> annotationType) {
            this.annotationType = annotationType;
        }

        //how about this method works
        //FunctionInterface callback method
        //if this method not exists, what should me do
        // 定义一个方法 入参 是class doWithMethods
        //看起来核心逻辑还是封装不变性
        public boolean hasAnnotationMethods(Class<?> clazz) {
            final AtomicBoolean found = new AtomicBoolean(false);
            ///这个抽象做的特别好，doWithMethods  对指定的class 想做什么操作就做什么操作
            //还能把业务逻辑代码前置
            ReflectionUtils.doWithMethods(clazz, method -> {
                if (found.get()) {
                    return;
                }
                Annotation annotation = AnnotationUtils.findAnnotation(method, AnnotationMethodsResolver.this.annotationType);
                if (annotation != null) {
                    found.set(true);
                }
            });
            return found.get();
        }
    }
}