package reference;

import org.aspectj.weaver.ast.Var;

import java.lang.ref.WeakReference;

/**
 * @description: 弱引用
 * @author: zhanghailang
 * @date: 2020/12/11 0011 23:55
 */
public class TWeakReference {

    /**
     * 弱引用遇到GC就会被回收 那它有什么用处呢
     * @param args
     */
    //   System.out.println
    public static void main(String[] args) {
        WeakReference<Re> re = new WeakReference<>(new Re());
        System.out.println(re.get());
        //垃圾回收一下
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(re.get());
    }
}
