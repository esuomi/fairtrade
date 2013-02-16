package fairtrade;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silverbox
 * Date: 9.2.2013
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class RTest {

    @Test
    public void canBeUsedForConnecting() throws Exception {

        ReConnection connection = R.connect(
            new ConnectionHandler() {
                @Override
                public void onConnect() {}
            },
            new FailureHandler() {
                @Override
                public void onFailure() {}
            });

        connection.close();
        connection.reconnect();
        connection.use("heroes");

        ReCursor cursor = connection.run(R.getTable("marvel"), new RowHandler() {
            @Override
            public void onRow(Row row) {

            }
        });

        R.getTable("marvel").run(new RowHandler() {
            @Override
            public void onRow(Row row) {

            }
        });

        R.getTable("marvel").run(true, new RowHandler() {
            @Override
            public void onRow(Row row) {

            }
        });

        for (Row row : cursor) { // Java-ish collect

        }

        QueryResponse<Database> createDbResponse = R.createDb("superheroes").execute();
        QueryResponse<Database> dropDbResponse = R.dropDb("superheroes").execute();
        QueryResponse<List<Database>> listDbsResponse = R.listDbs().execute();

        QueryResponse<ReTable> createTableResponse = R.createTable("marvel").execute();
        QueryResponse<ReTable> dropTableResponse = R.dropTable("marvel").execute();
        QueryResponse<List<ReTable>> listTablesResponse = R.listTables().execute();


        ObjectMapper mapper = new ObjectMapper();

        ObjectNode tonyStark = mapper.createObjectNode();
        tonyStark.put("superhero", "Iron Man");
        tonyStark.put("superpower", "Arc Reactor");

        R.getTable("marvel").insert(tonyStark).execute();

        ObjectNode peterParker = mapper.createObjectNode();
        peterParker.put("superhero", "Spiderman");
        peterParker.put("superpower", "spidy sense");

        R.getTable("marvel").insert(tonyStark, peterParker).execute();

        boolean overwrite = true;
        R.getTable("marvel").insert(overwrite, tonyStark).execute();

        final ObjectNode age = mapper.createObjectNode();
        age.put("age", 30);
        R.getTable("marvel").findById("superman").update(age).execute();

        R.getTable("marvel").findById("superman").update(new RowHandler() {
            @Override
            public void onRow(Row row) {
                row.increment("age", 1);
            }
        }).execute();

        R.getTable("marvel").findById("superman").execute();

        // implicitly keep same id for replacement doc
        R.getTable("marvel").findById("superman").replace(age).execute();

        R.getTable("marvel").findById("superman").delete().execute();

        QueryResponse<Database> db = R.getDatabase("heroes").execute();

        boolean useOutdated = true;
        QueryResponse<ReTable> table = R.getDatabase("heroes").getTable("marvel", useOutdated).execute();

        R.getTable("marvel").findById("superman").execute();
        R.getTable("marvel").find("name", "superman").execute();
        R.getTable("marvel").findBetween(10, 20).execute();
        R.getTable("marvel").findBetween("user_id", 10, 20).execute();

        ObjectNode activeAdults = mapper.createObjectNode();
        activeAdults.put("active", true);
        activeAdults.put("age", 30);
        R.getTable("marvel").find(activeAdults).execute();
    }
}
