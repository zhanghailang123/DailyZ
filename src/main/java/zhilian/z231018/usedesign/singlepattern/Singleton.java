package zhilian.z231018.usedesign.singlepattern;

/**
 * @author hailang.zhang
 * @since 2023-10-30
 */
public class Singleton {

    private static Singleton SINGLETON;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new Singleton();
        }
        return SINGLETON;
    }
}