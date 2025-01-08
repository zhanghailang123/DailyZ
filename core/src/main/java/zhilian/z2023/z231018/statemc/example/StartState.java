package zhilian.z2023.z231018.statemc.example;

/**
 * @author hailang.zhang
 * @since 2023-11-01
 */
public class StartState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}