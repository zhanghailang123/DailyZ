package zhilian.z2023.z221028;

/**
 * @author zhanghailang
 * @since 2022/10/28 21:45
 **/
public class ProxyTest {

    public static void main(String[] args) {
        UserServiceImpl param = new UserServiceImpl();
        UserService service = MyProxyUtil.getProxyByJDK(param);
        service.saveUser();
    }
}
