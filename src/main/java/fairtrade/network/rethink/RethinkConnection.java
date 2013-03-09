package fairtrade.network.rethink;

import fairtrade.network.Connection;

import java.net.InetAddress;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 22.2.2013
 */
public class RethinkConnection implements Connection {

    private final InetAddress address;

    public RethinkConnection(InetAddress address) {
        this.address = address;
    }
}
