package fairtrade.mock.server;

import java.io.IOException;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(Throwable t) {
        super(t);
    }
}
