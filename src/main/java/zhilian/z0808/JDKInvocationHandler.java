package zhilian.z0808;

import cn.hutool.core.util.ClassLoaderUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/8 0008 22:50
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheHandler cacheHandler;

    public JDKInvocationHandler(ICacheHandler cacheHandler) {
        this.cacheHandler = cacheHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        ICacheHandler.class.getMethod(method.getName(),
        return null;
    }
}