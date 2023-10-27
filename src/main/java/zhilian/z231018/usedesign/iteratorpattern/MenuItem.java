package zhilian.z231018.usedesign.iteratorpattern;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * 服务生
 * @author hailang.zhang
 * @since 2023-10-25
 */
public class MenuItem extends MenuComponent{

    public MenuItem(String name, String desc, Boolean isVegetarian, BigDecimal price) {
        this.name = name;
        this.desc = desc;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    /**
     * 菜品名字
     */
    private String name;

    /**
     * 菜品描述
     */
    private String desc;

    /**
     * 是否是素食
     */
    private Boolean isVegetarian ;

    /**
     * 菜品价格
     */
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Boolean isVegetarian() {
        return isVegetarian;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public Iterator createIterator() {
        return null;
    }
}