//package com.zhanghl.first.ConcurrTransactional;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author hailang.zhang
// * @since 2024-03-29
// */
//@Component
//public class SqlContext {
//
//    @Resource
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    public SqlSession getSqlSession() {
//        SqlSessionFactory factory = sqlSessionTemplate.getSqlSessionFactory();
//        return factory.openSession();
//    }
//}