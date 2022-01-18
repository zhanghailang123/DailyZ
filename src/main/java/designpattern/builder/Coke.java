package designpattern.builder;

import designpattern.builder.abstracts.ColdDrink;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 11:14
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 3.9f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}