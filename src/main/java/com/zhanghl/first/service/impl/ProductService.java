package com.zhanghl.first.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhanghl.first.dao.test.OrderMapper;
import com.zhanghl.first.model.entity.test.Order;
import com.zhanghl.first.model.entity.test.Product;
import com.zhanghl.first.dao.test.ProductMapper;
import com.zhanghl.first.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanghailang
 * @since 2023-01-29
 */

@Service(value = "ProductService2")
public class ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private TransactionTemplate transactionTemplate;
    //有问题就解决问题
    private static ReentrantLock lock = new ReentrantLock(true);
    //开箱即用的TransactionTemplate  be Normal
    @Transactional(rollbackFor = Exception.class)
//    @ConsistencyTask(id = "test111", performanceWay = PerformanceEnum.PERFORMANCE_SCHEDULE)
    public void sellProduct(String a) {
        //如何在项目中使用简单的责任链模式对项目的业务进行编排 怎么防止复杂业务的侵入
        //但是有时候可能最好是无状态的 有状态的维护比较复杂 而且会有并发问题
        //状态机和责任链模式的使用 怎么去混点Pr之类的东西
        //        lock.lock();
        //have a atention
        //
        try {
            Product product1 = this.transactionTemplate.execute(transactionStatus -> {
                //
                System.out.println(Thread.currentThread().getName() + " :抢到锁，进入方法");
                Product product = this.productMapper.selectById(1);
                Integer count = product.getCount();
                System.out.println(Thread.currentThread().getName() + " :当前库存 = " + count);
                if (count > 0) {
                    Product newProduct = new Product();
                    newProduct.setId(1);
                    newProduct.setCount(count - 1);
                    //                    this.baseMapper.updateById(newProduct);
                    //
                    //
                    //
                    //
                    //                    Order order = new Order();
                    //                    order.setProductName(Thread.currentThread().getName());
                    //                    order.setProduct("test");
                    //                    this.orderMapper.insert(order);
                    System.out.println(Thread.currentThread().getName() + " : 减库存，创建订单完毕");

                    throw new RuntimeException("11111");
                } else {
                    System.out.println(Thread.currentThread().getName() + " : 没库存了");
                }
                return new Product();
            });
        } finally {
//            lock.unlock();

            System.out.println(Thread.currentThread().getName() + " : 释放锁啦，快来抢");
        }
    }

    public void testFB(String cmpName) {
//        Map<String, String> header = new HashMap<String,String>();
//        header.put("apikey","uGdbde_E_RNzC6uypZvHMw");
//        Map<String, Object> param = new HashMap<String,Object>();
//        param.put("from ",1);
//        param.put("size ",100);
//        param.put("keyword",cmpName);
//        param.put("apikey","uGdbde_E_RNzC6uypZvHMw");
//        String s = HttpUtil.get("https://data.riskstorm.com//v1/company/search", param);
//
//        System.out.println(s);

        Map<String, Object> param = new HashMap<String,Object>();
        param.put("from ",1);
        param.put("91330100716105852F ",100);
        param.put("apikey","uGdbde_E_RNzC6uypZvHMw");
        String s = HttpUtil.get("https://data.riskstorm.com/v1/company/"+"91330100716105852F"+"/member", param);

        System.out.println(s);
    }
}
