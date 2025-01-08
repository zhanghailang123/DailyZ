package zhilian.z0807;

import lombok.Data;

/**
 * @description: POJO类
 * @author: zhanghailang
 * @date: 2021/8/7 0007 22:04
 */
@Data
public class CreateUserAPI {
    private String name;
    private String identity;
    private String mobile;
    private int age;
}