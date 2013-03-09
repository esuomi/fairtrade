package fairtrade.db.table;

import com.rethinkdb.protocol.Rethinkdb;
import fairtrade.db.Query;
import fairtrade.db.QueryResponse;
import fairtrade.db.QuerySerializationException;
import fairtrade.db.StartQuery;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 23.2.2013
 */
public class CreateTableQuery extends StartQuery implements Query {

    private final String database;
    private final String tableName;
    private static final String DEFAULT_PRIMARY_KEY = "id";

    private String dataCenter;
    private String primaryKey = DEFAULT_PRIMARY_KEY;
    private long cacheSize;

    public CreateTableQuery(String database, String tableName) {
        this(database, tableName, DEFAULT_PRIMARY_KEY);
    }

    public CreateTableQuery(String database, String tableName, String primaryKey) {
        super(Rethinkdb.Term.TermType.TABLE_CREATE);
        this.database = database;
        this.tableName = tableName;
        this.primaryKey = primaryKey;
    }

    public final CreateTableQuery withPrimaryKey(String newPrimaryKey) {
        return new CreateTableQuery(tableName, newPrimaryKey);
    }

    @Override
    protected void contributeArguments(Rethinkdb.Term.Builder argumentBuilder) {
        addArgument(argumentBuilder, database);
        addArgument(argumentBuilder, tableName);
    }

}
