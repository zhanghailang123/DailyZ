package zhilian.z231018.usedesign.use;

import zhilian.z231018.usedesign.strategypattern.FlyNoWay;
import zhilian.z231018.usedesign.strategypattern.Quack;

/**
 * @author hailang.zhang
 * @since 2023-10-23
 */
public class GreenDuck extends Duck{

    public GreenDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("this is look like green duck");
    }

    public static void main(String[] args) {
        Duck duck  =  new GreenDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}