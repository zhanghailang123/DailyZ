package com.zhanghl.first.z220207;

/**
 * @author zhanghailang
 * @since 2022/8/30 22:09
 **/
public class ClassLoadTest {

    public static void main(String[] args) {
        System.out.println(ClassLoadTest.class.getClassLoader());
        System.out.println(ClassLoadTest.class.getClassLoader().getParent());
        System.out.println(ClassLoadTest.class.getClassLoader().getParent().getParent());
        System.out.println(ClassLoadTest.class.getClassLoader().getParent().getParent().getParent());
    }
}
