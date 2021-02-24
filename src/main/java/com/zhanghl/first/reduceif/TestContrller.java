package com.zhanghl.first.reduceif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021-2-24 14:43
 */
@RestController
public class TestContrller {
    @Autowired
    private PayService2 payService2;
    @Autowired
    private PayService3 payService3;
    @PutMapping(value = "/test/{payCode}")
    public void test(@PathVariable("payCode") String payCode){
        payService2.pay(payCode);
        payService3.toPay(payCode);
        System.out.println("请求成功");
    }
}