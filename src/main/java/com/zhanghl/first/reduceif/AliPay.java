package com.zhanghl.first.reduceif;

import org.springframework.stereotype.Service;

/**
 * @description: pay1
 * @author: zhanghailang
 * @date: 2021-2-24 14:07
 */
@PayCode(value = "ali",name = "支付宝支付")
@Service
public class AliPay implements IPay {
    @Override
    public void pay() {
        System.out.println("--------发起支付宝支付");
    }
}