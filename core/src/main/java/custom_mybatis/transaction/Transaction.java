package custom_mybatis.transaction;

import java.sql.Connection;

/**
 * wrap a database connection
 * creation preparation commit/rollback
 * @author hailang.zhang
 * @since 2024-03-31
 */
public interface Transaction {

    Connection getConnection();
}
