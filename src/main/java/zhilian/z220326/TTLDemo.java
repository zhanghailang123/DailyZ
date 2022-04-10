package zhilian.z220326;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 阿里开源的TTL测试使用
 * 异步执行上下文的传递
 * 透明/自动完成所有异步执行上下文的可定制、规范化的捕捉和传递。
 * @author: zhanghailang
 * @date: 2022/4/10 0010 20:18
 */
public class TTLDemo {

    public static void main(String[] args) {
        final Map<String,String> context = getContext();

        Map<String,String> contextCopy = new HashMap<>(context);

        Runnable asyncLogic = () -> {
            System.out.println(contextCopy);
        };
        new Thread(asyncLogic).start();

    }

    private static final ThreadLocal<Map<String,String>> contextHolder = ThreadLocal.withInitial(HashMap::new);

    private static Map<String,String> getContext() {
        return contextHolder.get();
    }
}