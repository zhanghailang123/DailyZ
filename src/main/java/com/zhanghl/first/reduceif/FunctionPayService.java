package com.zhanghl.first.reduceif;

import org.springframework.stereotype.Service;

/**
 * @description: 具体的业务分类
 * @author: zhanghailang
 * @date: 2022/1/25 17:18
 */
@Service
public class FunctionPayService {
    public String aliPay() {
        System.out.println("ali Pay start");
        return "ali";
    }

    public String weiXinPay() {
        System.out.println("weiXin Pay start");
        return "weinXin";
    }

    public String jdPay() {
        System.out.println("jd Pay start");
        return "jd";
    }
}