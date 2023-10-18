package com.zhanghl.first.reduceif;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ClassUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hailang.zhang
 * @since 2023-10-18
 */
public class TestScanByAnno {

    public static void main(String[] args) {
        Map<String, Class<?>> cache = new HashMap<>(32);
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation("com.zhanghl.first.reduceif", PayCode.class);
        System.out.println(classes);
        classes.stream().forEach(a -> {
            PayCode annotation = a.getDeclaredAnnotation(PayCode.class);
            cache.put(annotation.value(), a);
        });
        Class<?> ali = cache.get("ali");
        System.out.println(ali);
    }
}