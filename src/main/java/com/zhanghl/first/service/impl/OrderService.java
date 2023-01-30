package com.zhanghl.first.service.impl;

import com.zhanghl.first.model.entity.test.Order;
import com.zhanghl.first.dao.test.OrderMapper;
import com.zhanghl.first.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanghailang
 * @since 2023-01-29
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
