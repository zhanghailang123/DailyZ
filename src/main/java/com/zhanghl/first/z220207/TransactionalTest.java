package com.zhanghl.first.z220207;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/7 9:39
 */
@Service
public class TransactionalTest {

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        System.out.println("start transactional test");
        throw new RuntimeException("test rollback");
    }

}