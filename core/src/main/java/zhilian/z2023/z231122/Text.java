package main.java.zhilian.z2023.z231122;

import java.util.regex.Pattern;

/**
 * @author hailang.zhang
 * @since 2023-11-27
 */
public class Text {

    public static void main(String[] args) {
        String regex = "^\\d{4}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("2023-01").matches());
    }
    private static boolean isValid(int age) {
        return age >= 18 && age <= 60;
    }
}