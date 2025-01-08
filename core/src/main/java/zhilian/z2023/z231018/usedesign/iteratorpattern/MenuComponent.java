package zhilian.z2023.z231018.usedesign.iteratorpattern;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * 组合模式特点：
 * 使用组合结构，我们能把相同的操作应用在组合和个别对象上。
 * 换句话说，在大多数情况下，我们可以忽略对象组合和个别对象之间的区别
 * 实现菜单：
 * 菜单组件提供了接口，让菜单项和菜单共同使用
 *
 * 缺点：
 * 组合模式以单一职责设计原则换取透明性
 * 透明性：
 * 通过组件的接口同时包含管理子节点和叶子节点的操作，客户就可以将组合节点和叶节点一视同仁
 *
 *
 * MenuComponent中同时具有两种类型的操作，因为客户有机会对一个元素做一些不恰当或者是没有意义的操作
 * 例如试图将菜单添加到菜单项中，所以我们失去了一些安全性
 * 这是设计上抉择。一个很典型的折中案例。
 *
 * 透明性：
 *  是指在使用某种技术或设计模式时，用户无需了解其内部实现细节，就可以使用该技术或者设计模式的特性
 *
 * @author hailang.zhang
 * @since 2023-10-26
 */
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDesc() {
        throw new UnsupportedOperationException();
    }

    public BigDecimal getPrice() {
        throw new UnsupportedOperationException();
    }

    public Boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    public abstract Iterator createIterator();
}