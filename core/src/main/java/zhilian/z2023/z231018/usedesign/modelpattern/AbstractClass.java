package zhilian.z2023.z231018.usedesign.modelpattern;

/**
 * 探究一下模板类 ：此抽象类内可以有哪些类型的方法
 * @author hailang.zhang
 * @since 2023-10-24
 */
public abstract class AbstractClass {

    final void templateMethod() {

    }

    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    /**
     * 这个具体的方法被定义在抽象类中 将它声明为final，这样一来子类无法覆盖它。它可以被模板方法直接使用 或者被子类使用
     */
    final void concreteOperation() {

    }

    void hook() {
        //这是一个具体的方法 但它什么事情都不做
        //我们也可以有”默认不做事的方法“，我们称这种方法为”hook“ 钩子。子类可以视情况决定要不要覆盖它们。
    }
}