package com.ruyuan.consistency.enums;

/**
 * 一致性任务状态枚举类
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public enum ConsistencyTaskStatusEnum {

    /**
     * 0:初始化 1:开始执行 2:执行失败 3:执行成功
     */
    INIT(0),
    START(1),
    FAIL(2),
    SUCCESS(3);

    private final int code;

    ConsistencyTaskStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
