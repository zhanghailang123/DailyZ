package custom_mybatis.impl;

import custom_mybatis.base.Configuration;
import custom_mybatis.SqlSession;
import custom_mybatis.base.Executor;

/**
 * @author hailang.zhang
 * @since 2024-03-31
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    private final Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }
}