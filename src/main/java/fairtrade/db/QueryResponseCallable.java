package fairtrade.db;

import com.rethinkdb.protocol.Rethinkdb;

import java.util.concurrent.Callable;

/**
 * TODO: Smarter name for this.
 *
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.3.2013
 */
class QueryResponseCallable<T extends QueryResponse> implements Callable<T> {

    private final Rethinkdb.Response response;
    private final Translator<T> translator;

    public QueryResponseCallable(Rethinkdb.Response response, Translator<T> translator) {
        this.response = response;
        this.translator = translator;
    }

    @Override
    public T call() throws Exception {
        switch (response.getType()) {
            case CLIENT_ERROR: return translator.onError(ErrorType.CLIENT, response);
            case COMPILE_ERROR: return translator.onError(ErrorType.COMPILE, response);
            case RUNTIME_ERROR: return translator.onError(ErrorType.RUNTIME, response);
            case SUCCESS_ATOM: return translator.onSuccess(SuccessType.ATOMIC, response);
            case SUCCESS_PARTIAL: return translator.onSuccess(SuccessType.PARTIAL_RESULT, response);
            case SUCCESS_SEQUENCE: return translator.onSuccess(SuccessType.SEQUENTIAL_RESULT, response);
        }
        return translator.onError(ErrorType.UNKNOWN, response);
    }
}
