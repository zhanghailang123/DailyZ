package zhilian.z231018.usedesign.statepattern;

/**
 * 找出应用中可能需要变化之处，把他们独立出来
 * 在糖果机中，状态就是一直在变化的部分，不同的状态动作不一样，我们完全可以去将其抽离出来
 * 自省与进步 源源不绝获取毫毛似的正反馈就已经很不容易了
 * 修正自己内心的思想
 * 在糖果机中，状态就是一直在变化的部分，不同的状态动作不一样。我们完全可以将其抽离出来
 * 通过使用状态模式，可以将对象的状态和行为分离，使得状态的变化独立于对象的行为。
 * @author hailang.zhang
 * @since 2023-10-23
 */
public abstract class State {

    /**
     * 投币
     */
    public abstract void insertQuarter();

    /**
     * 退币
     */
    public abstract void ejectQuarter();

    /**
     * 转动
     */
    public abstract void turnCrank();

    /**
     * 发糖
     */
    public abstract void dispense();

    protected void returnQuarter() {
        System.out.println("退币。。。。。");
    }

}