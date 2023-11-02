package zhilian.z231018.statemc.example;

/**
 * @author hailang.zhang
 * @since 2023-11-01
 */
public class StopState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Stop State");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}