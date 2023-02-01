package com.ruyuan.consistency.custom.shard;

/**
 * 任务分片键生成器接口
 * 如业务服务需要定制，实现该接口即可
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
public interface ShardingKeyGenerator {

    /**
     * 生产一致性任务分片键
     *
     * @return 一致性任务分片键
     */
    long generateShardKey();

}