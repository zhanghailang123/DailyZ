package zhilian.z231122;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdcardUtil;

/**
 * @author hailang.zhang
 * @since 2023-11-27
 */
public class Text {

    public static void main(String[] args) {
        int age = IdcardUtil.getAgeByIdCard("412928194606080028");
        System.out.println(age);
        System.out.println(Validator.isCitizenId("412928194606080028"));

        System.out.println(isValid(age));
    }
    private static boolean isValid(int age) {
        return age >= 18 && age <= 60;
    }
}