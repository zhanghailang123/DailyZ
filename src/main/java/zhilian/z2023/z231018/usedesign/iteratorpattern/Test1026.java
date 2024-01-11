package zhilian.z2023.z231018.usedesign.iteratorpattern;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class Test1026 {

    public static void main(String[] args) {
        //1698335999999
//        long lastDay = DateUtil.between(new Date(), DateTime.of("2023-10-26", "yyyy-MM-dd"), DateUnit.DAY, false);
        long lastDay = DateUtil.between(DateUtil.beginOfDay(new Date()), DateUtil.beginOfDay(DateTime.of(1698335999999L)), DateUnit.DAY, false);

        System.out.println("-----: " + lastDay);
    }
}