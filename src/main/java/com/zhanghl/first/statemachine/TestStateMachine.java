package com.zhanghl.first.statemachine;

import cn.hutool.core.lang.Validator;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description: cola 状态机测试使用
 * @author: zhanghailang
 * @date: 2022/6/2 17:44
 */
public class TestStateMachine {

    public static void main(String[] args) {
        StateMachineBuilder<Object, Object, Object> builder = StateMachineBuilderFactory.create();
//        builder.internalTransition().within().on().when().perform();
        new FutureTask<String>(() -> {
            return "";
        });

        TestFunction testFunction = str -> System.out.println("11111" + str);
        testFunction.accept("zzzzzz");

//        System.out.println(Validator.isMobile("13141957227\u202C"));
//        System.out.println(Validator.isMobile("\u202D13141957227\u202C"));
//        System.out.println(Validator.isCitizenId("430527197501114524"));
//        System.out.println(Validator.isCitizenId("411528198603066811"));
//        System.out.println(Validator.id("34220119950616751X"));
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangssan");
        list.add("zhangssan");
        list.add("zhangssan");
        list.add("ayan");
        list.add("ayan");
        list.add("ayan");
        list.add("lisi");
//        list.stream().filter(a  -> !distinct(a)).forEach(a -> {
//            System.out.println(a);
//        });
        /**
         * 那么你触及到本质了吗 出入参都是一个函数可以滴 有意思 函数的执行时机是在哪里呢 我打的断点的地方是执行时机吗 这里面有没有延时加载的存在呢
         */
        list.stream().filter(distinctByKey(String :: toString)).forEach(a -> {
            System.out.println(a);
        });
    }

    /**
     * OK 明确一下 你需要实现什么样的功能 判断已有的数据存不存在相同的类型
     * 入参 出参
     * @return
     */
//    private <U>Predicate<T> distinctByKey(Function<T,U> function) {
//        ConcurrentHashMap hashMap = new ConcurrentHashMap<T,T>();
//        hashMap.putIfAbsent(function.apply())
//        return 1==1;
//    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        // t
        //涉及两个函数式接口 这个方面的知识我是否还需要去补补呢，泛型的处理该是如何的呢   自由而不放纵
        //这个函数式编程的使用可以说是很巧妙的了 入参 是一个Function接口 为什么这么设计接口呢？ 好处是什么呢 细品一下啊 首先得从函数式编程的使用聊起来 来 回答下函数式编程的好处 react？
        //避免使用程序状态及易变对象，可以接受函数 当作输入和输出 那该怎么理解可变对象及使用程序状态呢
        //这个案例里面的输入和输出确实是个函数 定义好的 代码内部的业务实现才是关键点呀
        //精彩来了，看下这个返回 居然是一个lamda表达式 如果是是我 我不可能也想不到会是这样的设计 这个表达式为啥能代表Predicate函数接口呀 是根据什么来评判的 它这个咋定义的呀 怪怪的
        // 专注 如何定义Predicate
        ConcurrentHashMap<Object, Boolean> map = new ConcurrentHashMap<>();
        System.out.println("==============");
        return t -> put(map, t, keyExtractor) == null;
    }

    private static Boolean distinct(String testString) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        if (map.putIfAbsent(testString,Boolean.TRUE) == null) {
            return true;
        }
        return false;
    }

    //为什么顺序是这样的呢
    //那么在代码中的应用该是什么样子的呢
    //能够使用Lambda的依据是必须有相应的函数式接口，能够使用Lambda的依据是必须有相应的函数式接口
    //接下来需要专注的点、Spring三级缓存、分布式锁、Spring的内部流程和原理、泛型、函数式接口
    private static <T> Object put(Map map, T t, Function<? super T, Object> keyExtractor) {
        System.out.println("1111");
       return map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE);
    }
}