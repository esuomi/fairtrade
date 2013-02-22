package fairtrade.db;

import fairtrade.network.Result;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 22.2.2013
 */
public class TableTest {

    private static final String TABLE_NAME = "testingTable";
    private Table table;

    @Before
    public void setUp() throws Exception {
        table = new Table(TABLE_NAME);
    }

    @Test
    public void canBeUsedToSelectAllDataInTable() throws Exception {
        Result<Iterable<Document>> documents = table.execute();
    }
}
