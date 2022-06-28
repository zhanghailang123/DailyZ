package com.zhanghl.first.statemachine;

import cn.hutool.core.util.ReUtil;
import cn.hutool.json.JSONSupport;
import cn.hutool.json.JSONUtil;

import java.util.PriorityQueue;

/**
 * @description: 状态模式demo
 * @author: zhanghailang
 * @date: 2022/6/6 10:38
 */
public class StatePatternDemo {
    public static void main(String[] args) {
//        Context context = new Context();
//
//        StartState startState = new StartState();
//        startState.doAction(context);
//
//        System.out.println(context.getState().toString());
//
//        StopState stopState = new StopState();
//        stopState.doAction(context);
//
//        System.out.println(context.getState().toString());
        System.out.println(ReUtil.isMatch("[0-9]{1,}","122456657978945456564"));

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
//        JSONSupport
    }
}