package zhilian.z231018.usedesign.iteratorpattern;

/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu breakFast = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waiter waiter = new Waiter(breakFast,dinerMenu);
        waiter.printMenu();
    }
}