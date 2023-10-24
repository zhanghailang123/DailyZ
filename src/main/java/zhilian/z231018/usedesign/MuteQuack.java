package zhilian.z231018.usedesign;

/**
 * @author hailang.zhang
 * @since 2023-10-23
 */
public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("i cant quack");
    }
}