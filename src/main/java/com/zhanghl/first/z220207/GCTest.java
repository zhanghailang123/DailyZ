package com.zhanghl.first.z220207;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Try;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description: gc相关测试
 * @author: zhanghailang
 * @date: 2022/8/31 17:38
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[309000*1024];

//        Arrays.asList(1,2,3).stream().map(Objects::toString).collect(Collectors.toList());
//        List<String> list = Stream.of(1, 23, 3).map(Objects::toString).toList();
//        System.out.println(list);
//
//        Try.of(() -> 1/0).andFinally(()->{
//            System.out.println(1111);
//        });



    }
//    List transform (List source){
//        List dst = new ArrayList<>();
//        if (CollectionUtils.isEmpty()) {
//            return dst;
//        }
//        source.stream.  .parallel().map(..)  .filter(..)  .foreach(dst::add);
//        return dst;
//    }
}