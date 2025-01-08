package zhilian.z2024.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hailang.zhang
 * @since 2024-04-09
 */
public class UserProxyInvocationHandler implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        User user = new User();
        System.out.println("user study before like play");
        method.invoke(user, args);
        System.out.println("user study after like play");
        return null;
    }
}