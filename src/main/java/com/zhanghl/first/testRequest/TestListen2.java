package com.zhanghl.first.testRequest;

import com.zhanghl.first.dao.test.ProductMapper;
import com.zhanghl.first.model.entity.test.Product;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2023/1/30 14:48
 */
@Component
public class TestListen2 {
    @Resource
    private ProductMapper productMapper;

    @EventListener
    public void doSubs(TestEvent event) {
        System.out.println("当前线程："+Thread.currentThread().getName());
        Product product = new Product();
        product.setCount(222);
        this.productMapper.insert(product);
    }
}