package zhilian.z231018.usedesign.modelpattern;

import java.util.Arrays;

/**
 * @author hailang.zhang
 * @since 2023-10-24
 */
public class Coffee extends CaffeineBeverageWithHook{

    //通过属性控制hook函数的结果，进而影响模板方法的行为
    private Boolean wants;

    public void setWants(Boolean wants) {
        this.wants = wants;
    }

    @Override
    void brew() {
        System.out.println("使用冲泡的方式");
    }

    @Override
    void addCondiments() {
        System.out.println("给咖啡加入一些牛奶和糖");
    }

    @Override
    boolean customerWantsCondiments() {
        return this.wants;
    }

    public static void main(String[] args)  {
        Coffee coffee = new Coffee();
        coffee.setWants(Boolean.FALSE);

        coffee.prepareRescipe();

        Arrays.sort(new int[]{1, 2, 3});
    }
}