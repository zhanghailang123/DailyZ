package com.zhanghl.first.reduceif;

import org.springframework.stereotype.Service;

/**
 * @description: pay2
 * @author: zhanghailang
 * @date: 2021-2-24 14:09
 */
@PayCode(value = "weixin",name = "微信支付")
@Service
public class WeiXinPay implements IPay {
    @Override
    public void pay() {
        System.out.println("--------发起了微信支付");
    }
}