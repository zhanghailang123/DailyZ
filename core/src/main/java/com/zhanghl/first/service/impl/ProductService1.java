package com.zhanghl.first.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghl.first.dao.test.ProductMapper;
import com.zhanghl.first.model.entity.test.Product;
import com.zhanghl.first.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * @author hailang.zhang
 * @since 2023-02-15
 */
@Service("productService2")
public class ProductService1 extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public void sellProduct(String a) {

    }
}