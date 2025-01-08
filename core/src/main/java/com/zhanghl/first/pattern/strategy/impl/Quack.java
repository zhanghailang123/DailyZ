package com.zhanghl.first.pattern.strategy.impl;

import com.zhanghl.first.pattern.strategy.QuackBehavior;

/**
 * @author zhanghailang
 * @since 2022/8/25 22:16
 **/
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("呱呱呱！！@！");
    }
}
