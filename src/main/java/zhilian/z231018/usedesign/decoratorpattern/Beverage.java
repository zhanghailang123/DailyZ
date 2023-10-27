package zhilian.z231018.usedesign.decoratorpattern;

/**
 * 饮料父类
 * @author hailang.zhang
 * @since 2023-10-27
 */
public abstract class Beverage {
    String desc = "unknown beverage";

    public String getDesc() {
        return desc;
    }

    /**
     * 计算饮料价钱
     */
    public abstract double cost();
}
