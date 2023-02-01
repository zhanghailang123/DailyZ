package zhilian.z230109;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2023/1/12 9:02
 */
public class TestLLL {
    public static void main(String[] args) {
        System.out.println(DateUtil.offsetDay(DateUtil.beginOfQuarter(new Date()), -1).toDateStr());
    }
}