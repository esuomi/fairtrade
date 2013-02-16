package fairtrade;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silverbox
 * Date: 9.2.2013
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class R {

    private static Query<Database> defaultDatabase = null;


    public static ReConnection connect(ConnectionHandler connectionHandler, FailureHandler failureHandler) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public static TableQuery<ReTable> getTable(String tableName) {
        return defaultDatabase.getTable(tableName);
    }

    public static Query<Database> createDb(String db) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public static Query<Database> dropDb(String db) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public static Query<List<Database>> listDbs() {
        return null;
    }

    public static Query<ReTable> createTable(String marvel) {
    }

    public static Query<ReTable> dropTable(String marvel) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public static Query<List<ReTable>> listTables() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public static Query<Database> getDatabase(String heroes) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
