package Web;

import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Object o = new Object();

        String zhl = new String("zhanghailang");
        String ZY = new String("zhangyan");
//        FutureTask
//        Stack；
//        InternalThreadLocal

//        Executors.callable(0);
//        ThreadGroup;
//        ThreadPoolExecutor;
//        ThreadFactory
        List<Integer> list = Arrays.asList(1,2,11,3,4,44,22,9,2,2);
        list.stream().map(x -> x= x*3).collect(Collectors.toList()).forEach(System.out ::println);
        //Consumer<T> 转化掉了 不需要再做处理
        list.stream().map(x -> x+1).collect(Collectors.toList()).forEach( s->{
            System.out.println("输出"+ s+ 1);
        });
        list.stream().filter(a -> a > 1).forEach( a -> System.out.println("被过滤后的值" + a));
//        list.stream().reduce(BinaryOperator.maxBy());

        list.stream().distinct().forEach(System.out :: println );
        Optional optional= list.stream().findAny();
        System.out.println(optional.get() + "1111111111");
        //无锁 实现递增
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        list.stream().distinct();
//        DateUtil

    }

}
