package com.zhanghl.first.pattern.wrapper;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/8/30 12:37
 */
public interface Computable<A, V> {
    V compute(A arg) throws Exception ;
}