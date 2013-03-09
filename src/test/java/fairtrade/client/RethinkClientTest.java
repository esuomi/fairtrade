package fairtrade.client;

import fairtrade.db.table.Table;
import fairtrade.mock.server.RethinkServer;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkClientTest {

    private RethinkClient rethinkClient;

    private RethinkServer server;
    private String database;
    private InetAddress address;

    @Before
    public void setUp() throws Exception {
        database = "test-db";
        server = new RethinkServer();
    }

    @Test
    public void canAcquireTableReference() throws Exception {
        rethinkClient = new RethinkClient(database, address);
        Table table = rethinkClient.getTable("table");
        table.create();
    }
}
