package com.zhanghl.first.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: '
 * @author: zhanghailang
 * @date: 2022/6/17 14:47
 */
public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext("com.zhanghl.first.test");
        AA aa = (AA) acc.getBean("aa");
        System.out.println(aa.getA());

    }
}