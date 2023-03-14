package com.zhanghl.first.controller;

import com.zhanghl.first.model.entity.test.Product;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayDeque;

/**
 * @author hailang.zhang
 * @since 2023-03-14
 */
//@Component
//@Order(2147483646)
public class TestPostConstructProcessor {

    private final TestPostConstructServiceImpl testPostConstructService;

    public TestPostConstructProcessor(TestPostConstructServiceImpl testPostConstructService) {this.testPostConstructService = testPostConstructService;}

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.testPostConstructService.addProduct(new Product());
//    }

//    @PostConstruct
    public void init() {
        this.testPostConstructService.addProduct(new Product());
        ArrayDeque<String> deque = new ArrayDeque<>();
    }
}