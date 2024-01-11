package zhilian.z2023.z221220;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2023/1/3 17:07
 */
public class TestZzz {
    public String getNumbers(String content) {
        String pattern1="([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public static void main(String[] args) throws ParseException {
//        TestZzz zzz = new TestZzz();
//        System.out.println(zzz.getNumbers("2.57亿元"));

//        System.out.println(DateUtil.betweenYear(DateFormat.getDateInstance().parse("2021-09-23"), new Date(), false));
        String a = null;
//        System.out.println(a.equals("11"));
        System.out.println("11".equals(null));
        Long re = DateUtil.betweenYear(DateUtil.parseDate("2021/1/13"), new Date(), false);
        System.out.println(re);
    }
}