package designpattern.builder.abstracts;

import designpattern.builder.wrapper.Wrapper;
import designpattern.builder.interfacesz.Item;
import designpattern.builder.interfacesz.Packing;

/**
 * @description: 汉堡
 * @author: zhanghailang
 * @date: 2022/1/18 10:55
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}