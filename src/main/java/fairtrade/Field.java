package fairtrade;

import fairtrade.criteria.IntCriterion;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class Field {
    private final String fieldName;

    public Field(String fieldName) {

        this.fieldName = fieldName;
    }

    public Criterion<Integer> gt(int value) {
        return new IntCriterion(this, Rethinkdb.Term.TermType.GT, value);
    }
}
