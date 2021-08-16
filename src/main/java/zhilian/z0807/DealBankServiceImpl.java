package zhilian.z0807;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/7 0007 22:26
 */
public class DealBankServiceImpl {

    private static String remoteCall(AbstractAPI api) {
        BankAPI bankAPI = api.getClass().getAnnotation(BankAPI.class);
        bankAPI.url();
        StringBuilder builder = new StringBuilder();
        Arrays.stream(api.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(BankAPIField.class))
                .sorted(Comparator.comparingInt(a -> a.getAnnotation(BankAPIField.class).order()))
                .peek(field -> field.setAccessible(true))
                .forEach(field -> {
                    BankAPIField bankAPIField = field.getAnnotation(BankAPIField.class);
                    Object value = "";
                    try {
                        field.get(api);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                    switch (bankAPIField.type()) {
                        case "S": {
                            builder.append(String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ','_'));
//                            builder.append(String.format("%-" + bankAPIField.length() + "s", value.toString().replace(' ', '_'));
                            break;
                        }
                    }
                });
        return null;
    }

    public static void main(String[] args) {
        String value = "_zzz_YYYY_dakjh   p";
        System.out.println(String.format("%-" + 5 + "s", value.toString()).replace(' ','_'));
        String str=null;

        str=String.format("Hi,%s", "飞龙");          // 格式化字符串

        System.out.println(str);
    }
}