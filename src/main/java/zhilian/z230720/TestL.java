package zhilian.z230720;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hailang.zhang
 * @since 2023-07-28
 */
public class TestL {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("zhl",  "test");
        String test1 = map.putIfAbsent("zhl", "test22222");
        System.out.println(test1);
        System.out.println("put end : " + map.get("zhl"));

        //put 一个不存在的值
//        String test2 = map.putIfAbsent("zy", "test333333");
//        System.out.println(test2);
//        System.out.println("put end : " + map.get("zy"));

        //使用computeIfAbsent试试
        String test2 = map.computeIfAbsent("zy", k -> {
            return null;
        });
        System.out.println(test2);
        System.out.println("put end : " + map.get("zy"));

        // null value throw a exception
//        String test3 = map.put("anan", null);
//        System.out.println("put null : " + map.get("anan"));
    }
}