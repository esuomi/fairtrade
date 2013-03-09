package fairtrade.db;

import java.io.IOException;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 9.3.2013
 */
public class QuerySerializationException extends RuntimeException {
    public QuerySerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
