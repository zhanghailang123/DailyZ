package zhilian.z231018.usedesign.decoratorpattern.decorator;

import zhilian.z231018.usedesign.decoratorpattern.Beverage;
import zhilian.z231018.usedesign.decoratorpattern.Espresso;

/**
 * 这样的话 我理解 是不是不需要有过多的类爆炸
 * 通过组合的模式来替代一部分的继承场景
 * 讲道理到最后还是要看实际业务来选用合适的设计模式
 * 软件设计没有银弹
 * @author hailang.zhang
 * @since 2023-10-27
 */
public class StarBuckClient {

    public static void main(String[] args) {
        Espresso espresso = new Espresso();
        //此处会有客户端不清楚类型 导致引用的错误吗？
        Beverage beverage = new Mocha(espresso);

        System.out.println(beverage.getDesc() + " $ " +  beverage.cost());
    }
}