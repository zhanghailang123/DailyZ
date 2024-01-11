package zhilian.z2023.z231018.usedesign.decoratorpattern;

/**
 * @author hailang.zhang
 * @since 2023-10-27
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        desc = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 8.9;
    }
}