package com.zhanghl.first;

import com.zhanghl.first.reduceif.PayService2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@ServletComponentScan
@EnableCaching
@EnableAsync
@MapperScan("com.zhanghl.first.dao")
public class FirstApplication {

    public static void main(String[] args) {
//        SpringApplication.run(FirstApplication.class, args);
        SpringApplication springApplication = new SpringApplication(FirstApplication.class);
        springApplication.addListeners(new PayService2());
        springApplication.run(args);
    }

}
