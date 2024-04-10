package zhilian.z2024.proxy;

/**
 * @author hailang.zhang
 * @since 2024-04-09
 */
public class User implements IUser{

    @Override
    public void study() {
        System.out.println("user need study =======");
    }

    @Override
    public void eat() {
        System.out.println("user also need eat ====");
    }
}