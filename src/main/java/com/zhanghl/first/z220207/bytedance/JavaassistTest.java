package com.zhanghl.first.z220207.bytedance;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description: javaassist test
 * @author: zhanghailang
 * @date: 2022/3/23 0023 22:37
 */
public class JavaassistTest {

    public static void main(String[] args) {
//         471685.58 0.0 0.0 22047.39 0.0 0.0
//        BigDecimal a = new BigDecimal("471685.58");
//        BigDecimal b = new BigDecimal("0.0");
//        BigDecimal c = new BigDecimal("0.0");
//        BigDecimal d = new BigDecimal("22047.39");
//        BigDecimal g = new BigDecimal("0.0");
//        BigDecimal h = new BigDecimal("0.0");
//        System.out.println(a.add(b).add(c).add(d).add(g).add(h).doubleValue());
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Executors.newFixedThreadPool(5);
        System.out.println(DateUtil.date());
        long delaySeconds = DateUtil.between(DateTime.of("2022-10-20 06:05:00", DatePattern.NORM_DATETIME_PATTERN), DateUtil.date(), DateUnit.SECOND, false);
        System.out.println(delaySeconds);

        long delaySeconds1 = DateUtil.between(DateUtil.date(), DateTime.of("2022-10-20 06:05:00", DatePattern.NORM_DATETIME_PATTERN), DateUnit.SECOND, Boolean.FALSE);
        System.out.println(delaySeconds1);
    }
}