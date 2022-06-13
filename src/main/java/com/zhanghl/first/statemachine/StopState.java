package com.zhanghl.first.statemachine;

/**
 * @description: stop state
 * @author: zhanghailang
 * @date: 2022/6/6 10:37
 */
public class StopState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Stop state=====");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StopState{}";
    }
}