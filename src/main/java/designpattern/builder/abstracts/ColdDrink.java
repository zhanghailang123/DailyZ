package designpattern.builder.abstracts;

import designpattern.builder.wrapper.Bottle;
import designpattern.builder.interfacesz.Item;
import designpattern.builder.interfacesz.Packing;

/**
 * @description: 冷饮
 * @author: zhanghailang
 * @date: 2022/1/18 10:57
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}