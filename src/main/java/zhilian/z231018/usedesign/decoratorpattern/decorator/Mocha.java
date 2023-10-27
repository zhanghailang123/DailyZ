package zhilian.z231018.usedesign.decoratorpattern.decorator;

import zhilian.z231018.usedesign.decoratorpattern.Beverage;

/**
 * @author hailang.zhang
 * @since 2023-10-27
 */
public class Mocha extends CondimentDecorator{
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 20 + beverage.cost();
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ", mocha";
    }
}