package com.zhanghl.first.controller;


import com.zhanghl.first.service.IProductService;
import com.zhanghl.first.service.impl.ProductService;
import com.zhanghl.first.service.impl.ProductService1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhanghailang
 * @since 2023-01-29
 */
@RestController
@RequestMapping("//product")
public class ProductController {
    @Resource
    private ProductService ProductService2;
    @Resource
    private ProductService1 productService1;

    @GetMapping("/test")
    public void testProduct() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    this.ProductService2.sellProduct("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }
    }
}
