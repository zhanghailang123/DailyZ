package com.zhanghl.first.statemachine;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/6/6 10:33
 */
public class Context {

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private State state;

    public Context() {
        this.state = null;
    }

}