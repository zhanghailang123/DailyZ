package zhilian.z0807;

import org.springframework.data.relational.core.sql.In;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

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
//        Dese.idCardNum("",4, 4);
//        LinkedList<LinkedList<Integer>> linkedLists = new LinkedList<>();
//        linkedLists.removeLast();
//        LinkedList<Integer> test = new LinkedList<>();
//        test.add(1);
//        linkedLists.add(test);
//        System.out.println(linkedLists);
        String s = "11111";
        String substring = s.substring(0, 2);
        System.out.println(substring);
    }
}