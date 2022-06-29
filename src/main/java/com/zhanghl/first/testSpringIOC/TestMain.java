package com.zhanghl.first.testSpringIOC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: '
 * @author: zhanghailang
 * @date: 2022/6/17 14:47
 */
public class TestMain {

    public static void main(String[] args) {
        //注解扫描类启动Spring容器
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext("com.zhanghl.first.testSpringIOC");
        AA aa = (AA) acc.getBean("aa");
        System.out.println(aa.getA());

    }
}