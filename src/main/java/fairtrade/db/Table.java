package fairtrade.db;

import com.ning.http.client.AsyncHttpClient;
import fairtrade.network.Result;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 22.2.2013
 */
public class Table {
    private final String table;
    private final Connection connection;

    public Table(String tableName, Connection connection) {
        this.table = tableName;
        this.connection = connection;
    }

    public Result<Iterable<Document>> execute() {
        return connection.prepare();
    }
}
