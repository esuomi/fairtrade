package fairtrade.mock.server;

import com.rethinkdb.protocol.Rethinkdb;
import fairtrade.util.ByteUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * <p>All tests in this class are based on the spec as defined in RethinkDB's
 * <a href="https://github.com/rethinkdb/rethinkdb/wiki/protobuf_rfc_raw_spec">protobuf_rfc_raw_spec</a>.</p>
 *
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class RethinkServerTest {
    
    private RethinkServer server;

    @Before
    public void setUp() throws Exception {
        server = new RethinkServer();
    }


    @Test
    public void returns200ForCorrectVersionInt() throws Exception {

        byte[] bytes = ByteUtils.intToByteArray(Rethinkdb.Version.V0_1.getNumber());
        Request versionRequest = new MockRequest(bytes);
        Response response = mock(Response.class);

        server.handle(versionRequest, response);

        ArgumentCaptor<Integer> responseCode = ArgumentCaptor.forClass(Integer.class);
        verify(response, times(1)).setCode(responseCode.capture());

        assertThat(responseCode.getValue(), is(200));
    }

}
