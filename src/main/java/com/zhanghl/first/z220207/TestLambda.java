package com.zhanghl.first.z220207;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/8/24 15:39
 */
public class TestLambda {

    public static void main(String[] args) {
        List<String> str1 = new ArrayList<>();
        List<String> str2 = new ArrayList<>();
        str2.add("z");
        str2.add("h");
        str2.add("y");

        str2.stream().forEach(a -> {
            List<String> str3 = new ArrayList<>();
            str3.add("zzzzz");
            str1.addAll(str3);
        });

    }
}