package com.zhanghl.first.controller;


import com.zhanghl.first.service.IProductService;
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
    private IProductService productService;

    @GetMapping("/test")
    public void testProduct() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    this.productService.sellProduct("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }
    }
}
