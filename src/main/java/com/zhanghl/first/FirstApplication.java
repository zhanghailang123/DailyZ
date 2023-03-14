package com.zhanghl.first;

import com.ruyuan.consistency.annotation.EnableTendConsistencyTask;
import com.zhanghl.first.reduceif.PayService2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
@MapperScan("com.zhanghl.first.dao")
@EnableTendConsistencyTask
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class FirstApplication {

    public static void main(String[] args) {
//        SpringApplication.run(FirstApplication.class, args);
        SpringApplication springApplication = new SpringApplication(FirstApplication.class);
        springApplication.addListeners(new PayService2());
        springApplication.run(args);
    }

}
