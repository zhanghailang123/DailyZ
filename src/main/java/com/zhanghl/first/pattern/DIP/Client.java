package com.zhanghl.first.pattern.DIP;

/**
 * @author zhanghailang
 * @since 2022/8/28 21:53
 **/
public class Client {
    public static void main(String[] args) {
        IDriver zhangsan = new Driver();
        ICar benz = new Benzi();
        zhangsan.drive(benz);
    }
}
