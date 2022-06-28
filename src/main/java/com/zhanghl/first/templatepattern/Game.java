package com.zhanghl.first.templatepattern;

/**
 * @description: 抽象父类
 * @author: zhanghailang
 * @date: 2022/6/28 9:33
 */
public abstract class Game {

    abstract void init();
    abstract void start();
    abstract void end();

    public void play() {
        init();
        start();
        end();
    }
}