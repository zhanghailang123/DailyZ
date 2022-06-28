package com.zhanghl.first.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/6/17 14:40
 */
@Component
public class BB {

    @Autowired
    private AA aa;

    private Integer c;

    private String d;
}