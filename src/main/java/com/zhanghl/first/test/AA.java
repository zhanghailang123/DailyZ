package com.zhanghl.first.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/6/17 14:40
 */
@Component(value = "aa")
@Data
public class AA {

    @Autowired
    private BB bb;

    private String a = "test zhl";

    private String b;
}