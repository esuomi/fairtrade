package fairtrade.db;

import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;
import com.rethinkdb.protocol.Rethinkdb;

import java.util.concurrent.Callable;

/**
 * TODO: Smarter name for this.
 *
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.3.2013
 */
class QueryResponseCallable<T extends QueryResponse> implements Callable<T> {

    private final ListenableFuture<Response> response;
    private final Translator<T> translator;

    public QueryResponseCallable(ListenableFuture<Response> response, Translator<T> translator) {
        this.response = response;
        this.translator = translator;
    }

    @Override
    public T call() throws Exception {
        Rethinkdb.Response rethinkResponse = null; // TODO: This, obviously
        switch (rethinkResponse.getType()) {
            case CLIENT_ERROR: return translator.onError(ErrorType.CLIENT, rethinkResponse);
            case COMPILE_ERROR: return translator.onError(ErrorType.COMPILE, rethinkResponse);
            case RUNTIME_ERROR: return translator.onError(ErrorType.RUNTIME, rethinkResponse);
            case SUCCESS_ATOM: return translator.onSuccess(SuccessType.ATOMIC, rethinkResponse);
            case SUCCESS_PARTIAL: return translator.onSuccess(SuccessType.PARTIAL_RESULT, rethinkResponse);
            case SUCCESS_SEQUENCE: return translator.onSuccess(SuccessType.SEQUENTIAL_RESULT, rethinkResponse);
        }
        return translator.onError(ErrorType.UNKNOWN, rethinkResponse);
    }
}
