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
    // 冷静 集中 专注 努力
    // 冷静 集中 专注 努力
    // 冷静 集中 专注 努力
    private void method4(){
        //do something
        //处理map中的信息
        //...
    }

    //ThreadLocal
    //ThreadLocalMap
    //线程本地变量


    //为啥要设计成弱引用呢 首先如果不设计成弱引用 那么ThreadLocal对象 作为ThreadLocalMap的key一直会被当前线程持有 是个强引用的话，那么这个
    //TheadLocal对象的生命周期会和线程的存活周期一样，这样是不合理的

}