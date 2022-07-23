package Web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/3/1 11:37
 */
public class Compleable {

    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        System.out.println(DateUtil.beginOfDay(calendar.getTime()));
        System.out.println(DateUtil.beginOfDay(new Date()));

    }
}