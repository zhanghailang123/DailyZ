package com.ruyuan.consistency.custom.alerter;

import com.ruyuan.consistency.model.ConsistencyTaskInstance;

/**
 * 一致性框架告警接口
 * 具体告警通知动作由业务服务实现
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public interface ConsistencyFrameworkAlerter {

    /**
     * 发送告警通知
     * 用户拿到告警实例通知给对应的人，在该方法中实现即可
     *
     * @param consistencyTaskInstance 发送告警通知
     */
    void sendAlertNotice(ConsistencyTaskInstance consistencyTaskInstance);

}
