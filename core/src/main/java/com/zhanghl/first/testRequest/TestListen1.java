package com.zhanghl.first.testRequest;

import com.zhanghl.first.dao.test.ProductMapper;
import com.zhanghl.first.model.entity.test.Product;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2023/1/30 14:46
 */
@Component
public class TestListen1 {
    @Resource
    private ProductMapper productMapper;

    @EventListener
    public void doSubs(TestEvent event) {
        System.out.println("当前线程："+Thread.currentThread().getName());
        Product product = new Product();
        product.setCount(111);

        this.productMapper.insert(product);
        throw new RuntimeException("first");
    }
}