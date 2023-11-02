package zhilian.z231018.statemc.example;

/**
 * @author hailang.zhang
 * @since 2023-11-01
 */
public class Context {

    private StartState start;
    private StopState stop;
    private State state;

    public Context(StartState start, StopState stop) {
        this.start = new StartState();
        this.stop = new StopState();
        state = null;
    }

    public void doAction() {
        state.doAction(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}