package com.ruyuan.consistency.enums;

/**
 * 线程模型枚举
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public enum ThreadWayEnum {

    /**
     * 异步执行
     */
    ASYNC(1, "异步执行"),
    /**
     * 同步执行
     */
    SYNC(2, "同步执行");

    private final Integer code;

    private final String desc;

    ThreadWayEnum(int code, String desc) {
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
