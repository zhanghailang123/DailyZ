package zhilian.z2023.z220326;

import lombok.Data;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/4/24 15:24
 */
@Data
public class Student {
    private String name;
    private String sex;

    public String getNameAndSex() {
        return this.name + this.sex;
    }
}