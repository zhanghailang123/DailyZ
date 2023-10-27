package zhilian.z231018.usedesign.iteratorpattern;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class CafeMenu implements Menu{
    private Hashtable menuItems;

    public CafeMenu() {
        this.menuItems = new Hashtable();
        //先预置一些菜品

        addItem("dapanji", "xinjaing dapanjia haochi youpiany ", false, BigDecimal.valueOf(25));
        addItem("huoguo", "Chinese best food", false, BigDecimal.valueOf(100));
        addItem("kaochuan", "zibo kaochuan ", false, BigDecimal.valueOf(50));
        addItem("pijiu", "tingdao beer", true, BigDecimal.valueOf(10));
        addItem("pijiu", "tingdao beer", true, BigDecimal.valueOf(10));
        addItem("pijiu", "tingdao beer", true, BigDecimal.valueOf(10));
    }

    public void addItem(String name, String desc, boolean vegetarian, BigDecimal price) {
        MenuItem menuItem = new MenuItem(name, desc, vegetarian, price);
        menuItems.put(name, menuItem);
    }

    @Override
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}