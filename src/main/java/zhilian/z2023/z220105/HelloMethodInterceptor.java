package zhilian.z2023.z220105;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * 持续地关注自我意识和情绪
 * https://www.zhihu.com/collection/136507941
 * @author: zhanghailang
 * @date: 2022/1/5 0005 23:07
 */
public class HelloMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before: " + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after: " + method.getName());
        System.out.println(object);
        return object;
    }
}