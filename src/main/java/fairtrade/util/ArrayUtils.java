package fairtrade.util;

import fairtrade.Criterion;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class ArrayUtils {
    public static <T> Criterion<T>[] merge(Criterion<T> first, Criterion<T>[] more) {
        if (more.length > 0) {
            Criterion<T>[] os = new Criterion[more.length + 1];
            os[0] = first;
            System.arraycopy(more, 0, os, 1, more.length);
            return os;
        }
        return new Criterion[] { first };
    }
}
