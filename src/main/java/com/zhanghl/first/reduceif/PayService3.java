package com.zhanghl.first.reduceif;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @description: 核心处理类2
 * @author: zhanghailang
 * @date: 2021-2-24 17:15
 */
@Service
public class PayService3 implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static final String SUFFIX = "Pay";
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void toPay(String payCode){
        ((IPay)applicationContext.getBean(getBeanName(payCode))).pay();
        System.out.println(applicationContext.getBean(getBeanName(payCode)) + "111");
    }
    public String getBeanName(String payCode){
        return payCode + SUFFIX;
    }
}