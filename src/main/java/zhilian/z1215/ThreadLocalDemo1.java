package zhilian.z1215;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/12/16 15:28
 */
public class ThreadLocalDemo1 {

    private static ThreadLocal<Map> map = ThreadLocal.withInitial(() -> new HashMap());

    private void method1(){
        //do something
        map.get();
        //处理map中的信息
        method2();
    }

    private void method2(){
        //do something
        map.get();
        //处理map中的信息
        method3();
    }

    private void method3(){
        //do something
        map.get();
        //处理map中的信息
        method4();
    }

    private void method4(){
        //do something
        //处理map中的信息
        //...
    }

    //ThreadLocal
    //ThreadLocalMap
    //线程本地变量
    //被讨厌的勇气
    //专注
    //KeepT
    //温和而坚定的人
    //Dont lie to yourself
    //热爱 love


}