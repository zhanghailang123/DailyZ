package zhilian.z230824;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2023-10-09
 */
public class TestAviator {

    public static void main(String[] args) {
        Age age = new Age();
        age.setNewAge(100);
        User user = new User();
        user.setName("zhangsan");
        user.setAge(age);
        Map<String, Object> map = new HashMap<>();
        map.put("entity", user);
        Object execute = AviatorEvaluator.execute("entity.age.newAge > 10 ", map);
        System.out.println(execute);

    }
}