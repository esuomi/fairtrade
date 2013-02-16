import fairtrade.Criteria;
import fairtrade.Rethink;
import org.junit.Test;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class CriteriaTest {

    @Test
    public void canSpecifyGreaterThanGivenValue() throws Exception {
        String fieldName = "field";
        Criteria criteria = Rethink.field(fieldName).gt(32);
    }
}
