package com.ruyuan.consistency.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 一致性任务降级的相关配置
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
@ConfigurationProperties(prefix = "ruyuan.tend.consistency.action")
public class TendConsistencyFallbackConfigProperties {

    /**
     * 触发降级逻辑的阈值 任务执行次数 如果大于该值 就会进行降级
     */
    public Integer failCountThreshold = 0;

}
