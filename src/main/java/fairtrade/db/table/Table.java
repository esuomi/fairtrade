package fairtrade.db.table;

import fairtrade.db.Query;
import fairtrade.network.Connection;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 22.2.2013
 */
public class Table {
    private final String table;
    private final Connection connection;
    private final String database;

    public Table(String database, String tableName, Connection connection) {
        this.database = database;
        this.table = tableName;
        this.connection = connection;
    }

    public Query<TableResponse> create() {
        return new CreateTableQuery(connection, database, table);
    }
}
