package com.zhanghl.first.z220207;

import cn.hutool.core.util.NumberUtil;
import io.vavr.collection.Stream;
import io.vavr.control.Try;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description: gc相关测试
 * @author: zhanghailang
 * @date: 2022/8/31 17:38
 */
public class GCTest {

    public static void main(String[] args) {
        //how2j
        System.out.println(NumberUtil.decimalFormat(",###", BigDecimal.valueOf(1111111111)));
    }
}