package com.ruyuan.consistency.enums;

/**
 * 执行模式枚举
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public enum PerformanceEnum {

    /**
     * 立即执行
     */
    PERFORMANCE_RIGHT_NOW(1, "立即执行"),
    /**
     * 调度执行
     */
    PERFORMANCE_SCHEDULE(2, "调度执行");


    private final Integer code;

    private final String desc;

    PerformanceEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }

}
