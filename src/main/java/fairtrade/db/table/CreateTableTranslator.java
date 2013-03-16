package fairtrade.db.table;

import com.rethinkdb.protocol.Rethinkdb;
import fairtrade.db.ErrorType;
import fairtrade.db.Translator;
import fairtrade.db.SuccessType;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.3.2013
 */
public class CreateTableTranslator implements Translator<TableResponse> {
    @Override
    public TableResponse onError(ErrorType client, Rethinkdb.Response response) {
        return null;
    }

    @Override
    public TableResponse onSuccess(SuccessType partialResult, Rethinkdb.Response response) {
        return null;
    }
}
