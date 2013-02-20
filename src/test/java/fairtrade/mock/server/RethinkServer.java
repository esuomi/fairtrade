package fairtrade.mock.server;

import com.rethinkdb.protocol.Rethinkdb;
import fairtrade.network.RethinkClient;
import fairtrade.util.ByteUtils;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerServer;
import org.simpleframework.transport.Server;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkServer implements Container {

    private Server server;
    private final Connection connection;
    private final InetSocketAddress address;

    public RethinkServer() throws IOException {
        server = new ContainerServer(this);
        connection = new SocketConnection(server);
        address = new InetSocketAddress(RethinkClient.RETHINK_DEFAULT_PORT);

        connection.connect(address);
    }

    @Override
    public void handle(Request request, Response response) {
        try {
            byte[] requestBody = readBody(request);

            if (requestBody.length == Integer.SIZE / 8) {
                if (ByteUtils.byteArrayToInt(requestBody) == Rethinkdb.Version.V0_1_VALUE) {
                    response.setCode(200);
                } else {
                    response.setCode(400);
                }
            } else {
                response.setCode(400);
            }
        } catch (InvalidRequestException e) {
            response.setCode(500);
        }
    }

    private byte[] readBody(Request request) {
        try (InputStream is = request.getInputStream()) {

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();

            return buffer.toByteArray();
        } catch (IOException e) {
            throw new InvalidRequestException(e);
        }
    }
}
