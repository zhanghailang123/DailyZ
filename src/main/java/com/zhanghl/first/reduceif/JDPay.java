package com.zhanghl.first.reduceif;

import org.springframework.stereotype.Service;

/**
 * @description: pay3
 * @author: zhanghailang
 * @date: 2021-2-24 14:10
 */
@PayCode(value = "JD",name = "京东支付")
@Service
public class JDPay implements IPay{
    @Override
    public void pay() {
        System.out.println("--------发起了京东支付");
    }
}