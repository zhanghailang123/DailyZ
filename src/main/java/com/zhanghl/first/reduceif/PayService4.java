package com.zhanghl.first.reduceif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @description: 使用Lamda 函数式编程减少 if else
 * 参考公众号：https://mp.weixin.qq.com/s/79go9AFZgcnNM7uk_5Yaew
 * @author: zhanghailang
 * @date: 2022/1/25 17:09
 */
@Service
public class PayService4 {

    @Autowired
    private FunctionPayService functionPayService;

    private Map<String, Supplier<String>> payMap = new HashMap<>();

    /**
     * 初始化业务分派逻辑，代替了if-else 部分
     */
    @PostConstruct
    public void dispatcherInit() {
        payMap.put("ali",() -> functionPayService.aliPay());
        payMap.put("weiXin",() -> functionPayService.weiXinPay());
        payMap.put("jd",() -> functionPayService.jdPay());
    }

    public void pay(String payCode){
        this.payMap.get(payCode).get();
    }
}