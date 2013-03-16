package fairtrade.db;

import com.rethinkdb.protocol.Rethinkdb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 9.3.2013
 */
public abstract class StartQuery<T extends QueryResponse> implements Query<T> {
    private final Rethinkdb.Term.TermType queryTermType;
    private final long queryToken;
    private final Translator<T> translator;

    protected StartQuery(Rethinkdb.Term.TermType queryTermType, Translator<T> translator) {
        this.queryTermType = queryTermType;
        this.translator = translator;

        this.queryToken = System.nanoTime();
    }

    @Override
    public Callable<T> execute() {

        Rethinkdb.Query.Builder queryBuilder = Rethinkdb.Query.newBuilder();
        Rethinkdb.Term.Builder termBuilder = Rethinkdb.Term.newBuilder()
                                                           .setType(queryTermType);

        queryBuilder = queryBuilder.setType(Rethinkdb.Query.QueryType.START)
                                   .setToken(getQueryToken())
                                   .setQuery(contributeArguments(termBuilder));

        //TODO: obviously I'm just printing this here, this will be the byte output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Rethinkdb.Query query = queryBuilder.build();
            query.writeTo(baos);

            System.out.println(new String(baos.toByteArray()));
        } catch (IOException e) {
            throw new QuerySerializationException("Failed to serialize query", e);
        }

        // TODO: introduce ning request -> response wrapping, embed into QueryResponseCallable
        final Rethinkdb.Response response = null;

        return new QueryResponseCallable<>(response, translator);
    }

    protected abstract Rethinkdb.Term.Builder contributeArguments(Rethinkdb.Term.Builder argumentBuilder);


    protected final Rethinkdb.Term.Builder addArgument(
            Rethinkdb.Term.Builder termBuilder,
            Rethinkdb.Term.TermType type,
            String value) {

        Rethinkdb.Term.Builder argBuilder = Rethinkdb.Term.newBuilder();
        Rethinkdb.Datum.Builder datumBuilder = Rethinkdb.Datum.newBuilder();

        Rethinkdb.Term.Builder withArg = termBuilder.addArgs(argBuilder.setType(type)
                                                    .setDatum(datumBuilder.setType(Rethinkdb.Datum.DatumType.R_STR)
                                                            .setRStr(value)));
        return withArg;
    }

    public long getQueryToken() {
        return queryToken;
    }

}
