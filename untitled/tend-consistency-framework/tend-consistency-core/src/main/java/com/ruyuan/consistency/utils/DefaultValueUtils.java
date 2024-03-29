package com.ruyuan.consistency.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * 默认值工具类
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
@Slf4j
public class DefaultValueUtils {

    /**
     * 获取参数的值
     *
     * @param value        给定的值
     * @param defaultValue 默认值
     * @return 参数值
     */
    public static String getOrDefault(String value, String defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 获取参数的值
     *
     * @param value        给定的值
     * @param defaultValue 默认值
     * @return 参数值
     */
    public static Integer getOrDefault(Integer value, Integer defaultValue) {
        if (ObjectUtils.isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 获取参数的值
     *
     * @param value        给定的值
     * @param defaultValue 默认值
     * @return 参数值
     */
    public static Long getOrDefault(Long value, Long defaultValue) {
        if (ObjectUtils.isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 获取参数的值
     *
     * @param value        给定的值
     * @param defaultValue 默认值
     * @return 参数值
     */
    public static Boolean getOrDefault(Boolean value, Boolean defaultValue) {
        if (ObjectUtils.isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }


}
