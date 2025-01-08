package com.zhanghl.first.pattern;

/**
 * 这个duck1定义的超类有问题，并不是所有鸭子都会飞，不是所有鸭子都是呱呱叫
 * solution1：子类进行覆盖，不会飞的子类进行覆盖重写
 * solution2：继续设计子抽象类
 * solution3: 我们总是习惯性的总想用继承来实现改变的部分，实际我们可以将改变的部分抽离出来，用组合实现
 *  三个原则
 *  1.找出应用中可能需要变化之处，把他们独立出来
 *  2.针对接口编程，而不是针对实现
 *  3.多用组合，少用继承
 *
 *
 *
 *
 *
 * @author zhanghailang
 * @since 2022/8/25 22:00
 **/
public abstract class Duck1 {

    public void swim() {
        System.out.println("All duck can swim");
    }

    public abstract String display();

    public void fly() {
        System.out.println("飞~~~~~");
    }

    public void quack() {
        System.out.println("呱呱呱");
    }
}
