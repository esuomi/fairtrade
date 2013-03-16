package fairtrade.db;

import java.util.concurrent.Callable;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 23.2.2013
 */
public interface Query<T extends QueryResponse> {

    Callable<T> execute();

}
