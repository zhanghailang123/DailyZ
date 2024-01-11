package zhilian.z2023.z231018.usedesign.modelpattern;

/**
 * @author hailang.zhang
 * @since 2023-10-24
 */
public abstract class CaffeineBeverageWithHook {

    protected Boolean wants = true;

    void prepareRescipe() {
        //煮水
        boilWater();
        //冲泡
        brew();
        //倒入杯子
        pourInCup();
        //钩子判断客户是否需要佐料
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 冲泡
     */
    abstract void brew();

    /**
     * 添加佐料
     */
    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boilling water");
    }

    void pourInCup() {
        System.out.println("pouring into cup");
    }

    boolean customerWantsCondiments() {
        return wants;
    }
}