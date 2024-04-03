package custom_mybatis.transaction;

import javax.sql.DataSource;

/**
 * @author hailang.zhang
 * @since 2024-03-31
 */
public class Environment {

    private final String id;

    private final TransactionFactory transactionFactory;

    private final DataSource dataSource;

    public Environment(String id, TransactionFactory transactionFactory, DataSource dataSource) {
        this.id = id;
        this.transactionFactory = transactionFactory;
        this.dataSource = dataSource;
    }
}