package fairtrade.db.table;

import com.rethinkdb.protocol.Rethinkdb;
import fairtrade.db.Query;
import fairtrade.db.QueryResponse;
import fairtrade.db.QuerySerializationException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 23.2.2013
 */
public class TableQuery implements Query<TableResponse> {

    private static final String DEFAULT_PRIMARY_KEY = "id";

    private final String database;
    private final String tableName;

    private String dataCenter;
    private String primaryKey = DEFAULT_PRIMARY_KEY;
    private long cacheSize;

    public TableQuery(String database, String tableName) {
        this(database, tableName, DEFAULT_PRIMARY_KEY);
    }

    public TableQuery(String database, String tableName, String primaryKey) {
        this.database = database;
        this.tableName = tableName;
        this.primaryKey = primaryKey;
    }

    public final TableQuery withPrimaryKey(String newPrimaryKey) {
        return new TableQuery(database, tableName, newPrimaryKey);
    }

    /**
     * @return
     * @throws QuerySerializationException Thrown if generated query cannot be serialized.
     */
    @Override
    public final QueryResponse<TableResponse> execute() {

        Rethinkdb.Query.Builder queryBuilder = Rethinkdb.Query.newBuilder();

        Rethinkdb.Term.Builder createTableBuilder = Rethinkdb.Term.newBuilder();
        createTableBuilder.setType(Rethinkdb.Term.TermType.TABLE_CREATE);

        addArgument(createTableBuilder, database);
        addArgument(createTableBuilder, tableName);

        queryBuilder.setType(Rethinkdb.Query.QueryType.START)
                    .setToken(System.currentTimeMillis()) // TODO: I suppose this is OK but as the wise men say; trust but verify
                    .setQuery(createTableBuilder);

        //TODO: obviously I'm just printing this here, this will be the byte output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            queryBuilder.build().writeTo(baos);
            System.out.println(new String(baos.toByteArray()));
        } catch (IOException e) {
            throw new QuerySerializationException("Failed to serialize query", e);
        }

        return null;
    }

    private void addArgument(Rethinkdb.Term.Builder createTableBuilder, String str) {
        Rethinkdb.Term.Builder argBuilder = Rethinkdb.Term.newBuilder();
        Rethinkdb.Datum.Builder datumBuilder = Rethinkdb.Datum.newBuilder();

        createTableBuilder.addArgs(argBuilder.setType(Rethinkdb.Term.TermType.DATUM)
                .setDatum(datumBuilder.setType(Rethinkdb.Datum.DatumType.R_STR)
                        .setRStr(str)));


    }
}
