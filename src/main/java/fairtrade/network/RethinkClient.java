package fairtrade.network;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkClient {

    private final String host;
    private final int port;

    public static final int RETHINK_DEFAULT_PORT = 28015;

    public RethinkClient() {
        this("localhost");
    }

    public RethinkClient(String host) {
        this(host, RETHINK_DEFAULT_PORT);
    }

    public RethinkClient(String host, int port) {
        this.host = host;
        this.port = port;
        // TODO: connect to Rethink
    }
}
