package fairtrade.db;

import com.rethinkdb.protocol.Rethinkdb;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.3.2013
 */
public interface Translator<T extends QueryResponse> {
    T onError(ErrorType client, Rethinkdb.Response response);

    T onSuccess(SuccessType partialResult, Rethinkdb.Response response);
}
