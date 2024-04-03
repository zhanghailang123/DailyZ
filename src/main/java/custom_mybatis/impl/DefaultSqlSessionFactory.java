package custom_mybatis.impl;

import custom_mybatis.SqlSession;
import custom_mybatis.SqlSessionFactory;
import custom_mybatis.base.Configuration;

/**
 * @author hailang.zhang
 * @since 2024-03-31
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return null;
    }

    private SqlSession openSessionFromDataSource() {
//        Executor executor = new
//        DefaultSqlSession defaultSqlSession = new DefaultSqlSession(configuration);
//        return defaultSqlSession;
        return null;
    }
}