package zhilian.z2023.z231018.usedesign.iteratorpattern;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class DinerMenu implements Menu{

    private static final int MAX_ITEMS = 6;

    private int numberOfItems = 0;

    private MenuItem[] menuItems;

    public DinerMenu() {
        this.menuItems = new MenuItem[MAX_ITEMS];
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
        if (numberOfItems > MAX_ITEMS) {
            throw new RuntimeException("菜单满了");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems ++;
        }
    }

    public Iterator createIterator() {
        return Arrays.stream(menuItems).iterator();
    }
}