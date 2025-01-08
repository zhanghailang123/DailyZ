package zhilian.z1206;

import cn.hutool.core.date.DateUtil;
import java.util.Date;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/12/6 14:14
 */
public class TestBase64 {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        Date today = DateUtil.endOfDay(now);
        System.out.println(today);
        Date weekend = DateUtil.endOfWeek(now);
        System.out.println(weekend);
        System.out.println(DateUtil.compare(today,weekend));
    }
}