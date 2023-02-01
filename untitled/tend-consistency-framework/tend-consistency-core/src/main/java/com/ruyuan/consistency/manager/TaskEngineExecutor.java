package com.ruyuan.consistency.manager;

import com.ruyuan.consistency.model.ConsistencyTaskInstance;

/**
 * 任务执行引擎接口
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public interface TaskEngineExecutor {

    /**
     * 执行指定的任务实例
     *
     * @param taskInstance 任务实例信息
     */
    void executeTaskInstance(ConsistencyTaskInstance taskInstance);

    /**
     * 当执行任务失败的时候，执行该逻辑
     *
     * @param taskInstance 任务实例
     */
    void fallbackExecuteTask(ConsistencyTaskInstance taskInstance);

}
