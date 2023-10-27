package zhilian.z231018.usedesign.decoratorpattern.decorator;

import zhilian.z231018.usedesign.decoratorpattern.Beverage;

/**
 * @author hailang.zhang
 * @since 2023-10-27
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDesc();
}