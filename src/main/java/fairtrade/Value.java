package fairtrade;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public abstract class Value<T> {
    public static Value<Integer> of(int integer) {
        return new NumericValue(integer);
    }
}
