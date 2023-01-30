package com.zhanghl.first.service;

import com.zhanghl.first.model.entity.test.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanghailang
 * @since 2023-01-29
 */
public interface IProductService extends IService<Product> {

    void sellProduct();
}
