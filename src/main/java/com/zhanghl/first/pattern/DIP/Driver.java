package com.zhanghl.first.pattern.DIP;

/**
 * @author zhanghailang
 * @since 2022/8/28 21:44
 **/
public class Driver implements IDriver{

    @Override
    public void drive(ICar car) {
        car.run();
    }
}
