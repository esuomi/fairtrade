import fairtrade.Criterion;
import fairtrade.Rethink;
import org.junit.Test;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class CriterionTest {

    @Test
    public void canSpecifyGreaterThanGivenValue() throws Exception {
        String fieldName = "field";
        Criterion criterion = Rethink.field(fieldName).gt(32);

        // TODO: obviously this is missing assertions
    }
}
