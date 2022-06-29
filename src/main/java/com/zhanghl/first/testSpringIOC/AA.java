package com.zhanghl.first.testSpringIOC;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    private void testPostConstruct() {
        System.out.println("AA的post注解方法被调用了");
    }
}