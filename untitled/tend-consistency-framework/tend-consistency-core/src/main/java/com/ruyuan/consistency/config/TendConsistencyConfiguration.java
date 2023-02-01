package com.ruyuan.consistency.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 框架级配置参数
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TendConsistencyConfiguration {

    /**
     * 调度型任务线程池的核心线程数
     */
    public Integer threadCorePoolSize;
    /**
     * 调度型任务线程池的最大线程数
     */
    public Integer threadMaxPoolSize;
    /**
     * 调度型任务线程池的队列大小
     */
    public Integer threadPoolQueueSize;
    /**
     * 线程池中无任务时线程存活时间
     */
    public Long threadPoolKeepAliveTime;
    /**
     * 可选值:[SECONDS,MINUTES,HOURS,DAYS,NANOSECONDS,MICROSECONDS,MILLISECONDS] 线程池中无任务时线程存活时间单位
     */
    public String threadPoolKeepAliveTimeUnit;
    /**
     * 触发降级逻辑的阈值 任务执行次数 如果大于该值 就会进行降级
     */
    public Integer failCountThreshold;
    /**
     * 任务表是否进行分库
     */
    public Boolean taskSharded = false;
    /**
     * 这里要配置类型全路径且类要实现com.ruyuan.consistency.query.TaskTimeRangeQuery接口 如：com.xxx.TaskTimeLineQuery
     */
    private String taskScheduleTimeRangeClassName = "";
    /**
     * 生成任务表分片key的ClassName 这里要配置类型全路径且类要实现com.ruyuan.consistency.custom.shard.ShardingKeyGenerator接口
     */
    private String shardingKeyGeneratorClassName = "";

}