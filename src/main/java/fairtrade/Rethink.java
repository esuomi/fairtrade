package fairtrade;

import javax.management.Query;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class Rethink {
    public static Field field(String fieldName) {
        return new Field(fieldName);
    }
}
