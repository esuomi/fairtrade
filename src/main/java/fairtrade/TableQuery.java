package fairtrade;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created with IntelliJ IDEA.
 * User: Silverbox
 * Date: 9.2.2013
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
public class TableQuery<T> {
    public void run(RowHandler rowHandler) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void run(boolean useOutdated, RowHandler rowHandler) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public Query<InsertResult> insert(ObjectNode first, ObjectNode... more) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public Query<InsertResult> insert(boolean overwrite, ObjectNode first, ObjectNode... more) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public FindQuery find(String superman) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public FindQuery findById(String superman) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public QueryResponse<ReTable> execute() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public FindQuery find(String name, String superman) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public FindQuery findBetween(int i, int i1) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public FindQuery findBetween(String user_id, int i, int i1) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public FindQuery find(ObjectNode node) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
