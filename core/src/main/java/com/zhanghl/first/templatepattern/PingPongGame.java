package com.zhanghl.first.templatepattern;

/**
 * @description: 打乒乓子类
 * @author: zhanghailang
 * @date: 2022/6/28 9:35
 */
public class PingPongGame extends Game{
    @Override
    void init() {
        System.out.println("初始化打乒乓");
    }

    @Override
    void start() {
        System.out.println("开始打乒乓");
    }

    @Override
    void end() {
        System.out.println("结束打乒乓");
    }
}