package zhilian.z220105;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @description: 字节码之ASM的使用
 * 产品沉思录
 * @author: zhanghailang
 * @date: 2022/1/5 17:29
 */
public class ASMTest {

    public static void main(String[] args) {
        //首先来测试下CGlib的使用
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
        helloService.say();
    }
}