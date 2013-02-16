package fairtrade.util;

import fairtrade.Criterion;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class ArrayUtils {
    public static <T> Criterion[] merge(Criterion first, Criterion[] more) {
        if (more.length > 0) {
            Criterion[] os = new Criterion[more.length + 1];
            os[0] = first;
            System.arraycopy(more, 0, os, 1, more.length);
            return os;
        }
        return new Criterion[] { first };
    }
}
