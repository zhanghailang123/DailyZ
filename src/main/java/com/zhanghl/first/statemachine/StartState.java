package com.zhanghl.first.statemachine;

/**
 * @description: start state
 * @author: zhanghailang
 * @date: 2022/6/6 10:35
 */
public class StartState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Start state=====");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StartState{}";
    }
}