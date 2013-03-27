package fairtrade.db;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 27.3.2013
 */
public class QueryExecutionException extends RuntimeException {
    public QueryExecutionException(Throwable t) {
        super(t);
    }
}
