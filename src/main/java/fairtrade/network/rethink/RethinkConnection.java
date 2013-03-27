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

    @Override
    public String getServerURI() {
        // TODO: This is just stubbing, obviously needs better logic for digging the server URL
        //       Optimally I actually want to use a URI template builder here but at this point that's a bit too far fetched
        return address.getHostName() + ":" + address.getHostAddress();
    }
}
