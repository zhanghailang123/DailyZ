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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhanghailang
 * @since 2023-01-29
 */

@Service
@Slf4j
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private OrderMapper orderMapper;

    private static ReentrantLock lock = new ReentrantLock(true);

    @Transactional(rollbackFor = Exception.class)
    public void sellProduct() throws InterruptedException {
        lock.lock();
        try {
            log.info(Thread.currentThread().getName() + " :抢到锁，进入方法");
            Product product = this.productMapper.selectById(1);
            //查询库存够不够
            Integer count = product.getCount();
            log.info(Thread.currentThread().getName() + " :当前库存 = " + count);
            if (count > 0) {
                //更新库存
                Product newProduct = new Product();
                newProduct.setId(1);
                newProduct.setCount(count - 1);
                this.productMapper.updateById(newProduct);

                //创建订单
                Order order = new Order();
                order.setProductName(Thread.currentThread().getName());
                order.setProduct("test");
                this.orderMapper.insert(order);

                log.info(Thread.currentThread().getName() + "创建订单成功了");
            } else {
                log.info(Thread.currentThread().getName() + " : 没库存了");
            }
        } finally {
            lock.unlock();
            log.info(Thread.currentThread().getName() + " : 锁已释放============");
        }
    }
}
