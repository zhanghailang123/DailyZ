package zhilian.z231018.usedesign.use;

import zhilian.z231018.usedesign.FlyBehavior;
import zhilian.z231018.usedesign.QuackBehavior;

/**
 * @author hailang.zhang
 * @since 2023-10-23
 */
public abstract class Duck {

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("All duck can swim!");
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}