package com.ruyuan.consistency.exceptions;

/**
 * 异常类
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public class ConsistencyException extends RuntimeException {

    public ConsistencyException() {
    }

    public ConsistencyException(Exception e) {
        super(e);
    }

    public ConsistencyException(String message) {
        super(message);
    }


}
