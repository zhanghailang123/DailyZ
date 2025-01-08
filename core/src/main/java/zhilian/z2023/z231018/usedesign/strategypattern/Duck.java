package zhilian.z2023.z231018.usedesign.strategypattern;

/**
 * 练习下策略模式
 * 使用组合来实现 而不是继承
 * 1.找出应用中可能需要变化之处，把他们独立出来
 * 2.针对接口编程，而不是实现
 * 3.多用组合，少用继承
 * @author hailang.zhang
 * @since 2023-10-23
 */
public abstract class Duck {

    public void swim() {
        System.out.println("All duck can swim!");
    }

    public abstract void display();

    public void fly() {
        System.out.println("飞~~~");
    }

    public void quack() {
        System.out.println("呱呱呱~");
    }
}