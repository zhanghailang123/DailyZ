package com.zhanghl.first.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/7/19 9:16
 */
@Configuration
public class FiterConfig {

    @Bean
    public FilterRegistrationBean registrationFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 设置过滤器
        filterRegistrationBean.setFilter(new SaveInterfaceLogFilter());
        // 指定url策略
        filterRegistrationBean.addUrlPatterns("/redisTest");
        // 设置过滤器名称
        filterRegistrationBean.setName("SaveInterfaceLogFilter");
        return filterRegistrationBean;
    }
}