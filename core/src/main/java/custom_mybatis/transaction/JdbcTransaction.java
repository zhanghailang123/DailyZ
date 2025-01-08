package custom_mybatis.transaction;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author hailang.zhang
 * @since 2024-03-31
 */
public class JdbcTransaction implements Transaction{

    private Connection connection;
    private DataSource dataSource;
    private TransactionIsolationLevel level;

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return null;
    }
}