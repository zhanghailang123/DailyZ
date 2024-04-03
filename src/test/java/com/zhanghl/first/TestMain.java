package com.zhanghl.first;

import com.zhanghl.first.dao.test.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hailang.zhang
 * @since 2024-04-01
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMain {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        System.out.println(applicationContext.getApplicationName());
        this.productMapper.selectById(1);
    }
}