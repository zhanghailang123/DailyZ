package com.zhanghl.first.statemachine;

@FunctionalInterface
public interface TestFunction<T> {

    void accept(T t);

//    void first(T t);
}
