package com.zhanghl.first.reduceif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zhanghl.first.z220207.TransactionalTest;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022-1-24 14:43
 */
@RestController
public class TestContrller {

    @Autowired
    private PayService2 payService2;

    @Autowired
    private PayService3 payService3;

    @Autowired
    private PayService4 payService4;

    @Autowired
    private TransactionalTest transactionalTest;

    @PutMapping(value = "/test/{payCode}")
    public void test(@PathVariable("payCode") String payCode){

//        if ("ali".equals(payCode)) {
//            System.out.println("ali pay start");
//        }
//        if ("jd".equals(payCode)) {
//            System.out.println("jd pay start");
//        }
//        if ("weixin".equals(payCode)) {
//            System.out.println("weixin pay start");
//        }
        //.....

//        this.payService2.pay(payCode);
//        this.payService3.toPay(payCode);
//        this.payService4.pay(payCode);
        this.transactionalTest.testTransactional();
    }
}