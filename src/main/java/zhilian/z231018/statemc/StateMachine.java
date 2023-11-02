package zhilian.z231018.statemc;

/**
 * @author hailang.zhang
 * @since 2023-10-31
 */
public class StateMachine {

    public static StateMachine of() {
        return new StateMachine();
    }

    public void on(Condition condition) {
        //回调函数
    }

    public void doAction() {

    }
}