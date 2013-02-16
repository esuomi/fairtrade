package fairtrade.query;

import com.rethinkdb.protocol.Rethinkdb;
import fairtrade.Criterion;
import fairtrade.util.ArrayUtils;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 16.2.2013
 */
public class Query {
    private Rethinkdb.Term.TermType termType;
    private final Criterion[] criteria;

    private Query(Rethinkdb.Term.TermType termType, Criterion[] criteria) {
        this.termType = termType;
        this.criteria = criteria;
    }

    public static Query filter(Criterion first, Criterion... more) {
        return new Query(Rethinkdb.Term.TermType.FILTER, ArrayUtils.merge(first, more));
    }

    public Rethinkdb.Query toRethinkQuery() {



        return null;
    }
}
