package designpattern.builder.wrapper;

import designpattern.builder.interfacesz.Packing;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 10:52
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}