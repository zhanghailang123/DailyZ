package com.zhanghl.first.templatepattern;

/**
 * @description: 踢足球子类
 * @author: zhanghailang
 * @date: 2022/6/28 9:37
 */
public class FootballGame extends Game{
    @Override
    void init() {
        System.out.println("初始化踢足球");
    }

    @Override
    void start() {
        System.out.println("开始踢足球");
    }

    @Override
    void end() {
        System.out.println("结束踢足球");
    }
}