import com.rethinkdb.Rethinkdb;
import fairtrade.Rethink;
import fairtrade.query.Query;
import org.junit.Test;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class QueryTest {

    @Test
    public void canCreateFilterQueryFromGivenCriteria() throws Exception {
        Query prepared = Query.filter(
            Rethink.field("foo").gt(2),
            Rethink.field("bar").gt(7));

        Rethinkdb.Query rethinkQuery = prepared.toRethinkQuery();
    }
}
