package zhilian.z2023.z231018.usedesign.strategypattern;

/**
 * @author hailang.zhang
 * @since 2023-10-23
 */
public class Squack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("zhizhizhi~~~~");
    }
}