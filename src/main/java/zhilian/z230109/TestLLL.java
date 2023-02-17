package zhilian.z230109;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2023/1/12 9:02
 */
public class TestLLL {
    public static void main(String[] args) {
        DateTime start = DateUtil.offsetDay(DateUtil.beginOfQuarter(new Date()), -1);
        DateTime end = DateUtil.beginOfQuarter(DateUtil.offsetDay(DateUtil.beginOfQuarter(new Date()), -1));
        System.out.println(start);
        System.out.println(end);
    }
}