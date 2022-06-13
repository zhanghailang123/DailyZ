package com.zhanghl.first.statemachine;

import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;

import java.util.concurrent.FutureTask;

/**
 * @description: cola 状态机测试使用
 * @author: zhanghailang
 * @date: 2022/6/2 17:44
 */
public class TestStateMachine {

    public static void main(String[] args) {
        StateMachineBuilder<Object, Object, Object> builder = StateMachineBuilderFactory.create();
//        builder.internalTransition().within().on().when().perform();
        new FutureTask<String>(() -> {
            return "";
        });
    }
}