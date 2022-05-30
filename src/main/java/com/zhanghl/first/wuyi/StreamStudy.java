package com.zhanghl.first.wuyi;

import org.springframework.data.relational.core.sql.In;

import java.util.Arrays;
import java.util.List;

/**
 * @description: Stream流加深印象
 * @author: zhanghailang
 * @date: 2022/5/2 0002 21:41
 */
public class StreamStudy {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,46,3,34,53,3,53,53,45,34);
        list.parallelStream().forEach(integer -> {
            System.out.println(integer + " :zzzzz");
        });
    }
}