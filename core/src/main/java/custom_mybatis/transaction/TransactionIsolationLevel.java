package custom_mybatis.transaction;

import java.sql.Connection;

public enum TransactionIsolationLevel {

    NONE(Connection.TRANSACTION_NONE),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED)

    ;

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }
}
