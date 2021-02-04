package reference;

/**
 * @description: 测试使用的类
 * @author: zhanghailang
 * @date: 2020/12/10 0010 22:50
 */
public class Re {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("开始执行finalize方法");
    }
}