package designpattern.builder.wrapper;

import designpattern.builder.interfacesz.Packing;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 10:51
 */
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}