package fairtrade.db;

import com.rethinkdb.protocol.Rethinkdb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 9.3.2013
 */
public abstract class StartQuery implements Query {
    private final Rethinkdb.Term.TermType queryTermType;

    protected StartQuery(Rethinkdb.Term.TermType queryTermType) {
        this.queryTermType = queryTermType;
    }

    @Override
    public QueryResponse execute() {

        Rethinkdb.Query.Builder queryBuilder = Rethinkdb.Query.newBuilder();

        Rethinkdb.Term.Builder termBuilder = Rethinkdb.Term.newBuilder();
        termBuilder.setType(queryTermType);

        contributeArguments(termBuilder);

        queryBuilder.setType(Rethinkdb.Query.QueryType.START)
                    .setToken(System.currentTimeMillis()) // TODO: I suppose this is OK but as the wise men say; trust but verify
                    .setQuery(termBuilder);

        //TODO: obviously I'm just printing this here, this will be the byte output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            queryBuilder.build().writeTo(baos);
            System.out.println(new String(baos.toByteArray()));
        } catch (IOException e) {
            throw new QuerySerializationException("Failed to serialize query", e);
        }

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected abstract void contributeArguments(Rethinkdb.Term.Builder argumentBuilder);


    protected final void addArgument(Rethinkdb.Term.Builder termBuilder, String str) {
        Rethinkdb.Term.Builder argBuilder = Rethinkdb.Term.newBuilder();
        Rethinkdb.Datum.Builder datumBuilder = Rethinkdb.Datum.newBuilder();

        termBuilder.addArgs(argBuilder.setType(Rethinkdb.Term.TermType.DATUM)
                   .setDatum(datumBuilder.setType(Rethinkdb.Datum.DatumType.R_STR)
                                         .setRStr(str)));
    }
}
