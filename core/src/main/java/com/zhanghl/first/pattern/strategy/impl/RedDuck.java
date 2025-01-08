package com.zhanghl.first.pattern.strategy.impl;

import com.zhanghl.first.pattern.strategy.Duck;

/**
 * @author zhanghailang
 * @since 2022/8/25 22:21
 **/
public class RedDuck extends Duck {

    public RedDuck() {
        flyBehavior = new FlyNoway();
        quackBehavior = new Squeak();
    }

    @Override
    public String display() {
        return "我是一支红鸭子";
    }

    public static void main(String[] args) {
        Duck duck = new RedDuck();
        duck.performFly();
    }
}
