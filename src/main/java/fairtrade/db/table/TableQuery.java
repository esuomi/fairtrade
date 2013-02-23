package fairtrade.db.table;

import fairtrade.db.Query;
import fairtrade.db.QueryResponse;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 23.2.2013
 */
public class TableQuery implements Query<TableResponse> {

    private final String primaryKey;
    private static final String DEFAULT_PRIMARY_KEY = "id";

    public TableQuery() {
        this(DEFAULT_PRIMARY_KEY);
    }

    public TableQuery(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public final TableQuery withPrimaryKey(String newPrimaryKey) {
        return new TableQuery(newPrimaryKey);
    }


    @Override
    public final QueryResponse<TableResponse> execute() {
        return null;
    }
}
