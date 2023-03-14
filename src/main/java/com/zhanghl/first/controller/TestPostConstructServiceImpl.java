package com.zhanghl.first.controller;

import com.zhanghl.first.dao.test.ProductMapper;
import com.zhanghl.first.model.entity.test.Product;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author hailang.zhang
 * @since 2023-03-14
 */
@Service
public class TestPostConstructServiceImpl{

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private TestPostConstructServiceImpl testPostConstructService;

    /**
     * 添加产品
     * @param product 产品
     */
    public void addProduct(Product product) {
        System.out.println("======================开始保存商品了");
        //......省略业务逻辑
        ((TestPostConstructServiceImpl)AopContext.currentProxy()).save();
        System.out.println("======================保存商品结束了");
    }

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        //保存业务数据
        Product product = new Product();
        product.setId(1);
        product.setCount(111);
        this.productMapper.insert(product);

        // 保存操作记录
        // save record
    }

    /**
     * 上线前初始化数据
     */
    @PostConstruct
    public void init() {
        //模拟循环数据源  添加product
        for(;;) {
            this.testPostConstructService.addProduct(new Product());
//            addProduct(new Product());
        }

    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        //模拟循环数据源  添加product
//        addProduct(new Product());
//        return bean;
//    }
}