package com.zhanghl.first.reduceif;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 核心处理类
 * @author: zhanghailang
 * @date: 2021-2-24 14:11
 */
@Service
public class PayService2 implements ApplicationListener<ContextRefreshedEvent> {
    private static Map<String,IPay> payMap = null;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        Map<String,Object> beansWithAnno = applicationContext.getBeansWithAnnotation(PayCode.class);
        if (beansWithAnno != null){
            payMap = new HashMap<>();
            beansWithAnno.forEach((key,value) ->{
                String bizType = value.getClass().getAnnotation(PayCode.class).value();
                payMap.put(bizType,(IPay) value);
            });
        }
    }

    public void pay(String code){
        payMap.get(code).pay();
    }
}