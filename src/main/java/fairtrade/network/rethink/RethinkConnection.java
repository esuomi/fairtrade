package fairtrade.network.rethink;

import fairtrade.network.Connection;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 22.2.2013
 */
public class RethinkConnection implements Connection {
    private final String host;
    private final int port;

    public RethinkConnection(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
