package zhilian.z2023.z231018.usedesign.decoratorpattern;

/**
 * 真实实现类-浓缩咖啡
 * @author hailang.zhang
 * @since 2023-10-27
 */
public class Espresso extends Beverage{

    public Espresso() {
        desc = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}