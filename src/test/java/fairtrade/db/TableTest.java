package fairtrade.db;

import fairtrade.db.table.Table;
import fairtrade.db.table.TableResponse;
import fairtrade.network.Connection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Callable;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 22.2.2013
 */
public class TableTest {

    private static final String TABLE_NAME = "testing-table";
    private static final String DATABASE = "testing-database";
    private Table table;

    @Mock private Connection connection;

    {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void setUp() throws Exception {
        table = new Table(DATABASE, TABLE_NAME, connection);
    }

    @Test
    public void canBeUsedToCreateTable() throws Exception {
        Callable<TableResponse> resp = table.create().execute();
    }
}
