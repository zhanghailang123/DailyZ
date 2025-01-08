package zhilian.z2023.z231018.usedesign.iteratorpattern;

import java.util.Iterator;

/**
 * @author hailang.zhang
 * @since 2023-10-25
 */
public class Waiter {
    private Menu breafastMenu;
    private Menu dinerMenu;

    public Waiter(Menu breafastMenu, Menu dinerMenu) {
        this.breafastMenu = breafastMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator breafastMenuIterator = breafastMenu.createIterator();
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        System.out.println("MENU\n------\nBREAKFAST：");
        printMenu(breafastMenuIterator);
        System.out.println("\nDENER：");
        printMenu(dinerMenuIterator);
    }

    public void printBreakfastMenu() {

    }

    public void printLauchMenu() {

    }

    public void printVegetarianMenu() {

    }

    public Boolean isVegetarian(String name) {
        return Boolean.FALSE;
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + "，");
            System.out.println(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDesc());
        }
    }
}