package com.zhanghl.first.wuyi;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @description: 事务测试
 * @author: zhanghailang
 * @date: 2022/4/30 0030 14:47
 */
@Component
public class TransactionTest {

    private final TransactionTemplate transactionTemplate;

    public TransactionTest(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void testTransac() {
//        this.transactionTemplate.execute();
    }
}