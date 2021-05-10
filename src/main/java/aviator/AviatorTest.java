package aviator;

import com.googlecode.aviator.AviatorEvaluator;
import org.springframework.aop.framework.AopContext;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: Aviator表达式测试下使用
 * @author: zhanghailang
 * @date: 2020/10/1 0001 22:37
 */
public class AviatorTest {

    public static void main(String[] args) {
//        Long result = (Long)AviatorEvaluator.execute("1 + 2 + 3");
//        System.out.println("这是一个测试:" + result);
        List<String> strings = Arrays.asList("aaa","bbb","","ccc","zhl","","zy");
        List<String> filterStrings = strings.stream().filter(String -> !String.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表" + filterStrings);
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        List<String> stringList = Arrays.asList("a","bb","cc","dd","zz","","hh","ll");
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap = stringList.stream()
                .collect( Collectors.toMap( a -> stringList.indexOf(a), a -> a ) );
        Collectors.toList();
        hashMap.forEach((key,value) -> {System.out.println(key +"vvvvv" + value);});
        System.out.println(stringList.indexOf(stringList));
        /**
         * Jdk 1.7 合并字符创的方法
         */
        String mergedString  = getMergedString(stringList,"zhl!");
        System.out.println("1.7合并后的字符串" + mergedString);

        /**
         * Jdk 1.8 合并字符串的方法
         */
        mergedString = stringList.stream().collect(Collectors.joining(",,,"));
        String mergedString1  = stringList.stream().filter(str ->!str.isEmpty()).collect(Collectors.joining("????"));
        System.out.println("去空后的字符串" + mergedString1);
        System.out.println("1.8合并后的字符串" + mergedString);

    }
    private static String getMergedString(List<String> list,String separator){
//        AopContext.currentProxy();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : list){
            if (!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0,mergedString.length()-2);
//        return mergedString;
        //合并后的字符串azhl!bbzhl!cczhl!ddzhl!zzzhl!hhzhl!llzhl!
        //合并后的字符串azhl!bbzhl!cczhl!ddzhl!zzzhl!hhzhl!llzh
    }
}