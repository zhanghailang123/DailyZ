package com.zhanghl.first.controller;

import com.zhanghl.first.dao.test.OrderMapper;
import com.zhanghl.first.dao.test.ProductMapper;
import com.zhanghl.first.model.entity.test.Order;
import com.zhanghl.first.model.entity.test.Product;
import com.zhanghl.first.service.IProductService;
import com.zhanghl.first.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hailang.zhang
 * @since 2023-09-11
 */
@RestController
public class TransactionTestController {

    @Resource
    private ProductService productService;

    @PostMapping("/testTransaction")
    @Transactional(rollbackFor = Exception.class)
    public String doTransaction(int s) {
        //模拟多线程执行
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    productService.sellProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        return "OK";
    }

    private void doTransaction() {
        //        ReentrantLock lock = new ReentrantLock();
        //        lock.lock();
        //
        //        try {
        //            Integer count = this.productMapper.selectById(1).getCount();
        //            System.out.println(Thread.currentThread().getName() + " ----现有库存个数：" + count);
        //            if (count > 0) {
        //                Product product = new Product();
        //                product.setCount( count - 1);
        //                product.setId(1);
        //                this.productMapper.updateById(product);
        //            } else {
        //                System.out.println("不好意思，商品售完了");
        //            }
        //        } finally {
        //            //锁先释放了，但是事务还没提交
        //            lock.unlock();
        //        }
        //        //sync send mq for third
        //        asyncSendMq(new Product());
    }

    private void asyncSendMq(Product product) {
        new Thread(() -> {
            System.out.println(product.toString());
        }).start();
    }
}