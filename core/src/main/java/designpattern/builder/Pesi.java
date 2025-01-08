package designpattern.builder;

import designpattern.builder.abstracts.ColdDrink;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 11:15
 */
public class Pesi extends ColdDrink {

    @Override
    public float price() {
        return 3.6f;
    }

    @Override
    public String name() {
        return "Pesi";
    }
}