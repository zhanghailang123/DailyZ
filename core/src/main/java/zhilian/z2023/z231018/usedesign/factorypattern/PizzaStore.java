package zhilian.z2023.z231018.usedesign.factorypattern;

/**
 * 使用Pizza的客户端
 * @author hailang.zhang
 * @since 2023-10-30
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}