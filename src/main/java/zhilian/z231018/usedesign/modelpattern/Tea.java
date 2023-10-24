package zhilian.z231018.usedesign.modelpattern;

/**
 * @author hailang.zhang
 * @since 2023-10-24
 */
public class Tea extends CaffeineBeverageWithHook{

    public Tea(Boolean wants) {
        super.wants = wants;
    }

    @Override
    void brew() {
        System.out.println("使用浸泡的方式");
    }

    @Override
    void addCondiments() {
        System.out.println("茶叶中添加枸杞");
    }
//
//    boolean customerWantsCondiments() {
//        return wants;
//    }

    public static void main(String[] args) {
        Tea a = new Tea(true);
        a.prepareRescipe();
    }
}