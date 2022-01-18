package designpattern.builder;

import designpattern.builder.abstracts.Burger;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 11:10
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.1f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}