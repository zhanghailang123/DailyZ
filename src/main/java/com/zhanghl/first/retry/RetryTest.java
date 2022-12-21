package com.zhanghl.first.retry;


/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/4/17 0017 22:48
 */
public class RetryTest {
    public static void main(String[] args) {
        String a = "http:s1dasda";
        String replace = a.replace("http", "https");
        System.out.println(replace);
//        System.out.println(StrUtil.removePrefix("http", a));
        System.out.println(a);
    }
}