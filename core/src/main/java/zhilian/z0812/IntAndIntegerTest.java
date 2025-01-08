package zhilian.z0812;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: https://mp.weixin.qq.com/s/6fk40V04iw__orZjlI_Peg
 * @author: zhanghailang
 * @date: 2021/8/12 0012 23:03
 */
public class IntAndIntegerTest {


    /**
     * Integer变量和 new Integer()变量比较永远是False  因为Integer变量指向的是java常量池中的对象，而new Integer() 变量指向的是堆中新建的对象， 两者在内存的地址不同
     * @param args
     */
    public static void main(String[] args) {
        Integer i = 100;
        Integer j = 100;
        System.out.println(i == j);
        //-128  -127
        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n);

//        ThreadPoolExecutor executor = new Fix();
        Executors.newFixedThreadPool(5);
    }

}