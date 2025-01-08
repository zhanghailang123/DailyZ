package com.zhanghl.first;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
@MapperScan("com.zhanghl.first.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(FirstApplication.class);
        springApplication.run(args);
    }
}
