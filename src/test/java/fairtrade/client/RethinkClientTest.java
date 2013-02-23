package fairtrade.client;

import fairtrade.db.table.Table;
import fairtrade.mock.server.RethinkServer;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkClientTest {

    private RethinkClient rethinkClient;

    private RethinkServer server;

    @Before
    public void setUp() throws Exception {
        server = new RethinkServer();
    }

    @Test
    public void canAcquireDatabaseConnectionToRethink() throws Exception {
        rethinkClient = new RethinkClient();
    }

    @Test
    public void canAcquireTableReference() throws Exception {
        rethinkClient = new RethinkClient();
        Table table = rethinkClient.getTable("table");
    }
}
