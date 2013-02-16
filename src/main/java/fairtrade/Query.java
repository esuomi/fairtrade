package fairtrade;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silverbox
 * Date: 9.2.2013
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public interface Query<ResponseType> {

    QueryResponse<ResponseType> execute();

    TableQuery<ReTable> getTable(String marvel);

    TableQuery<ReTable> getTable(String marvel, boolean useOutdated);
}
