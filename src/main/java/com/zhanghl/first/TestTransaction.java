package com.zhanghl.first;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: test
 * @author: zhanghailang
 * @date: 2022/1/5 17:43
 */
@RestController
public class TestTransaction {

    @PutMapping(value = "/test-transatioanl")
    public void testTransaction(){
        this.method1();
    }

    @Transactional(rollbackFor = Exception.class)
    public void method1(){
        System.out.println("test transactional start");
        throw new RuntimeException("test transactional ex");
    }
}