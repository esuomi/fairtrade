package fairtrade.client;

import fairtrade.network.rethink.RethinkConnection;
import fairtrade.db.table.Table;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkClient {

    public static final int RETHINK_DEFAULT_PORT = 28015;
    private final RethinkConnection rethinkConnection;

    public RethinkClient() {
        this("localhost");
    }

    public RethinkClient(String host) {
        this(host, RETHINK_DEFAULT_PORT);
    }

    public RethinkClient(String host, int port) {
        this.rethinkConnection = new RethinkConnection(host, port);

    }

    public Table getTable(String table) {
        return new Table(table, rethinkConnection);
    }
}
