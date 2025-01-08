package zhilian.z2023.z231018.usedesign.strategypattern;

/**
 * @author hailang.zhang
 * @since 2023-10-23
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("i cant fly。。。。。。");
    }
}