package fairtrade;

import fairtrade.criteria.IntCriteria;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class Field {
    private final String fieldName;

    public Field(String fieldName) {

        this.fieldName = fieldName;
    }

    public Criteria gt(int value) {
        return new IntCriteria(this, Rethinkdb.Term.GT, value);
    }
}
