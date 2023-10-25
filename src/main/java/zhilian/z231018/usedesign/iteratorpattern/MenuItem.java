package zhilian.z231018.usedesign.iteratorpattern;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * 服务生
 * @author hailang.zhang
 * @since 2023-10-25
 */
public class MenuItem {

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
    @JSONField
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
}