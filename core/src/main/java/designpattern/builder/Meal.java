package designpattern.builder;

import designpattern.builder.interfacesz.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 意识被淹没在信息洪流中
 * 能清醒地意识到自己在干什么的人 应当是成功的
 * @author: zhanghailang
 * @date: 2022/1/18 11:18
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        //TODO
//        return items.stream().
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }
    
    public void showItems() {
        this.items.stream().forEach(item -> {
            System.out.println(item.name());
            System.out.println(item.packing().pack());
            System.out.println(item.price());
        });
    }
}