package com.zhanghl.first.controller;

import lombok.Data;

/**
 * @author hailang.zhang
 * @since 2023-03-22
 */
@Data
public class Rule {

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则表达式
     */
    private String ruleExpression;

    /**
     * 命中规则描述
     */
    private String hitDesc;
}