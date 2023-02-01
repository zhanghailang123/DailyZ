package com.ruyuan.consistency.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public class DateUtils {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(DateUtils.class);

    /**
     * 获得num天前的日期
     *
     * @param startDate    开始时间
     * @param calendarUnit 时间单位 用Calendar.DATE、Calendar.HOUR 即可
     * @return num天前的日期
     */
    public static Date getDateByDayNum(Date startDate, int calendarUnit, int num) {
        if (num == 0) {
            return startDate;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        calendar.add(calendarUnit, num);
        return calendar.getTime();
    }

}
