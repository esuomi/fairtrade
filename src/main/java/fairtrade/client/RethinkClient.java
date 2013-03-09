package fairtrade.client;

import fairtrade.network.rethink.RethinkConnection;
import fairtrade.db.table.Table;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkClient {

    public static final int RETHINK_DEFAULT_PORT = 28015;
    private final RethinkConnection rethinkConnection;
    private final String database;


    public RethinkClient(String database, InetAddress address) {
        this.database = database;
        this.rethinkConnection = new RethinkConnection(address);

    }

    public Table getTable(String table) {
        return new Table(database, table, rethinkConnection);
    }
}
