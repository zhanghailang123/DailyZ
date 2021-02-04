package Web;

import java.util.HashMap;

/**
 * @description: 静态代码块中调用静态变量或者方法
 * @author: zhanghailang
 * @date: 2020/9/6 0006 15:32
 */
public class StaticTest {
    static String  aa  = "111";
    static {
        HashMap hashMap = new HashMap();
        hashMap.put(aa,"1");
        hashMap.put(aa,"2");
    }
    //调用下面这个静态变量会报错
    static String  bb = "222";
}