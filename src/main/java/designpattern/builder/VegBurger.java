package designpattern.builder;

import designpattern.builder.abstracts.Burger;
import designpattern.builder.interfacesz.Packing;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 11:06
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public Packing packing() {
        return super.packing();
    }

    @Override
    public float price() {
        return 25.0f;
    }
}