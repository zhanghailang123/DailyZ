package zhilian.z2024.proxy;

import java.lang.reflect.Proxy;

/**
 * @author hailang.zhang
 * @since 2024-04-09
 */
public class TestProxyMain {

    public static void main(String[] args) {
        IUser userProxy = (IUser) Proxy.newProxyInstance(User.class.getClassLoader(), new Class[]{IUser.class}, new UserProxyInvocationHandler());
        userProxy.study();

        userProxy.eat();
    }
}