package fairtrade.db.table;

import fairtrade.db.Query;
import fairtrade.db.StartQuery;
import fairtrade.network.Connection;

import static com.rethinkdb.protocol.Rethinkdb.Term.Builder;
import static com.rethinkdb.protocol.Rethinkdb.Term.TermType.*;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 23.2.2013
 */
public class CreateTableQuery extends StartQuery<TableResponse> implements Query<TableResponse> {

    private final String database;
    private final String tableName;
    private static final String DEFAULT_PRIMARY_KEY = "id";

    private String dataCenter;
    private String primaryKey = DEFAULT_PRIMARY_KEY;
    private long cacheSize;

    public CreateTableQuery(Connection connection, String database, String tableName) {
        this(connection, database, tableName, DEFAULT_PRIMARY_KEY);
    }

    public CreateTableQuery(Connection connection, String database, String tableName, String primaryKey) {
        super(connection, TABLE_CREATE, new CreateTableTranslator());
        this.database = database;
        this.tableName = tableName;
        this.primaryKey = primaryKey;
    }

    public final CreateTableQuery withPrimaryKey(String newPrimaryKey) {
        return new CreateTableQuery(getConnection(), tableName, newPrimaryKey);
    }

    @Override
    protected Builder contributeArguments(Builder argumentBuilder) {
        Builder withDb = addArgument(argumentBuilder, DB, database);
        Builder withTableName = addArgument(withDb, DATUM, tableName);

        return withTableName;
    }

}
