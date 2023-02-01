package com.ruyuan.consistency.custom.query;

import java.util.Calendar;
import java.util.Date;

import static com.ruyuan.consistency.utils.DateUtils.getDateByDayNum;

/**
 * 任务执行时间范围查询器接口
 * 如业务服务需要定制，实现该接口即可
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public interface TaskTimeRangeQuery {

    /**
     * 获取查询任务的初始时间
     *
     * @return 启始时间
     */
    Date getStartTime();

    /**
     * 获取查询任务的结束时间
     *
     * @return 结束时间
     */
    Date getEndTime();

    /**
     * 每次最多查询出多少个未完成的任务出来
     *
     * @return 未完成的任务数量
     */
    Long limitTaskCount();

    /**
     * 如果没有实现类，框架默认实现：获取查询任务的初始时间
     *
     * @return 启始时间
     */
    static Date getStartTimeByStatic() {
        return getDateByDayNum(new Date(), Calendar.HOUR, -1);
    }

    /**
     * 如果没有实现类，框架默认实现：获取查询任务的结束时间
     *
     * @return 结束时间
     */
    static Date getEndTimeByStatic() {
        return new Date();
    }

    /**
     * 如果没有实现类，框架默认实现：每次最多查询出多少个未完成的任务出来
     *
     * @return 未完成的任务数量
     */
    static Long limitTaskCountByStatic() {
        return 1000L;
    }

}
