package com.zhanghl.first.pattern.strategy.impl;

import com.zhanghl.first.pattern.strategy.FlyBehavior;

/**
 * @author zhanghailang
 * @since 2022/8/25 22:13
 **/
public class FlyNoway implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("我不能飞~~~");
    }
}
