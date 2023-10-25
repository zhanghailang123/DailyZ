package zhilian.z231018.usedesign.strategypattern;

/**
 * @author hailang.zhang
 * @since 2023-10-23
 */
public class FlyWithRocket implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("flying with rocket");
    }
}