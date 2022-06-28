package com.zhanghl.first.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description:Spring Test
 * @author: zhanghailang
 * @date: 2022/6/21 13:35
 */
@Slf4j
public class UserInfo implements BeanFactoryAware, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    private String age;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        BeanPostProcessor
    }

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}