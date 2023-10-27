package zhilian.z231018.usedesign.iteratorpattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 一个十分特性化的菜单
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class PancakeHouseMenu implements Menu{
    private ArrayList menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList();
        //先预置一些菜品

        addItem("caffee", "real made in susa", true, BigDecimal.valueOf(5));
        addItem("mantou", "white AND soft all people love", true, BigDecimal.valueOf(1));
        addItem("doujiang", "fresh douzi ", true, BigDecimal.valueOf(3));
        addItem("youtiao", "big and cu da youtioa", true, BigDecimal.valueOf(4));
    }

    public void addItem(String name, String desc, boolean vegetarian, BigDecimal price) {
        MenuItem menuItem = new MenuItem(name, desc, vegetarian, price);
        menuItems.add(menuItem);
    }

    @Deprecated
    public ArrayList getMenuItems() {
        return menuItems;
    }

    /**
     * 为了封装统一的返回 不再返回上述的
     * @link getMenuItems()
     * @return
     */
    public Iterator createIterator() {
        return menuItems.iterator();
    }

    //.....其他的一些方法
}