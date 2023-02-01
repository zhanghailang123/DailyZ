package com.zhanghl.first.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ruyuan.consistency.annotation.ConsistencyTask;
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
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanghailang
 * @since 2023-01-29
 */
@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private TransactionTemplate transactionTemplate;

    private static ReentrantLock lock = new ReentrantLock(true);

//    @Transactional(rollbackFor = Exception.class)
    @ConsistencyTask(id = "test111")
    @Override
    public void sellProduct(String a) {
//        lock.lock();


        try {
//            this.transactionTemplate.execute(transactionStatus -> {
                System.out.println(Thread.currentThread().getName() + " :抢到锁，进入方法");
                Product product = this.baseMapper.selectById(1);
                Integer count = product.getCount();
                System.out.println(Thread.currentThread().getName() + " :当前库存 = " + count);
                if (count > 0) {
                    Product newProduct = new Product();
                    newProduct.setId(1);
                    newProduct.setCount(count - 1);
                    this.baseMapper.updateById(newProduct);




                    Order order = new Order();
                    order.setProductName(Thread.currentThread().getName());
                    order.setProduct("test");
                    this.orderMapper.insert(order);
                    System.out.println(Thread.currentThread().getName() + " : 减库存，创建订单完毕");

                    throw new RuntimeException("11111");

                } else {
                    System.out.println(Thread.currentThread().getName() + " : 没库存了");
                }
//
//                return null;
//
//            });


        } finally {
//            lock.unlock();

            System.out.println(Thread.currentThread().getName() + " : 释放锁啦，快来抢");
        }
    }
}
