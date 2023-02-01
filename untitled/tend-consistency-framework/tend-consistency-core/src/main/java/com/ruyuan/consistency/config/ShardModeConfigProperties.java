package com.ruyuan.consistency.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 任务分库相关的配置
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ruyuan.tend.consistency.shard")
public class ShardModeConfigProperties {

    /**
     * 任务表是否进行分库
     */
    public Boolean taskSharded = false;
    /**
     * 生成任务表分片key的ClassName 这里要配置类型全路径且类要实现com.ruyuan.consistency.custom.shard.ShardingKeyGenerator接口
     */
    private String shardingKeyGeneratorClassName = "";

}
