/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.search.query.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.QueryTimeoutException;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.graph.GraphSemantic;
import org.hibernate.graph.RootGraph;
import org.hibernate.graph.spi.AppliedGraph;
import org.hibernate.graph.spi.RootGraphImplementor;
import org.hibernate.query.KeyedPage;
import org.hibernate.query.KeyedResultList;
import org.hibernate.query.ResultListTransformer;
import org.hibernate.query.TupleTransformer;
import org.hibernate.query.spi.AbstractQuery;
import org.hibernate.query.spi.MutableQueryOptions;
import org.hibernate.query.spi.ParameterMetadataImplementor;
import org.hibernate.query.spi.QueryImplementor;
import org.hibernate.query.spi.QueryParameterBindings;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.search.engine.search.query.SearchQuery;
import org.hibernate.search.engine.search.query.spi.SearchQueryImplementor;
import org.hibernate.search.mapper.orm.loading.spi.EntityGraphHint;
import org.hibernate.search.mapper.orm.loading.spi.MutableEntityLoadingOptions;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.orm.search.query.spi.HibernateOrmSearchQueryHints;
import org.hibernate.search.mapper.orm.search.query.spi.HibernateOrmSearchScrollableResultsAdapter;
import org.hibernate.search.util.common.SearchTimeoutException;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;

@Deprecated(since = "8.1", forRemoval = true)
@SuppressForbiddenApis(reason = "We need to use the internal QueryOptionsImpl" + " in order to implement a org.hibernate.query.Query")
// For some reason javac issues warnings for all methods returning this; IDEA doesn't.
@SuppressWarnings({ "unchecked", "removal" })
public final class HibernateOrmSearchQueryAdapter<R> extends AbstractQuery<R> {

    public static <R> HibernateOrmSearchQueryAdapter<R> create(SearchQuery<R> query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final SearchQueryImplementor<R> delegate;

    private final MutableEntityLoadingOptions loadingOptions;

    HibernateOrmSearchQueryAdapter(SearchQueryImplementor<R> delegate, SessionImplementor sessionImplementor, MutableEntityLoadingOptions loadingOptions) {
        super(sessionImplementor);
        this.delegate = delegate;
        this.loadingOptions = loadingOptions;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    //-------------------------------------------------------------
    // Supported ORM/JPA query methods
    //-------------------------------------------------------------
    @Override
    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> cls) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<R> list() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmSearchQueryAdapter<R> setHint(String hintName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmSearchQueryAdapter<R> setTimeout(int timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmSearchQueryAdapter<R> setTimeout(Integer timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("rawtypes")
    @Deprecated(since = "8.0")
    public HibernateOrmSearchQueryAdapter<R> applyGraph(RootGraph graph, GraphSemantic semantic) {
        applyGraph((RootGraphImplementor) graph, semantic);
        return this;
    }

    @Override
    public ScrollableResultsImplementor<R> scroll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getResultCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyedResultList<R> getKeyedResultList(KeyedPage<R> page) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsupportedOperationException keyedResultListNoSupported() {
        return new UnsupportedOperationException("Keyed result lists are not supported in Hibernate Search queries");
    }

    @Override
    protected ScrollableResultsImplementor<R> doScroll(ScrollMode scrollMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected List<R> doList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void beforeQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void extractQueryOptions() {
        MutableQueryOptions queryOptions = getQueryOptions();
        Integer queryFetchSize = queryOptions.getFetchSize();
        if (queryFetchSize != null) {
            loadingOptions.fetchSize(queryFetchSize);
        }
        Integer queryTimeout = queryOptions.getTimeout();
        if (queryTimeout != null) {
            delegate.failAfter(Long.valueOf(queryTimeout), TimeUnit.SECONDS);
        }
        EntityGraphHint<?> entityGraphHint = null;
        if (isGraphApplied(queryOptions)) {
            AppliedGraph appliedGraph = queryOptions.getAppliedGraph();
            RootGraph<?> graph = appliedGraph.getGraph();
            if (graph != null) {
                entityGraphHint = new EntityGraphHint<>(graph, appliedGraph.getSemantic());
            }
        }
        loadingOptions.entityGraphHint(entityGraphHint, true);
    }

    //-------------------------------------------------------------
    // Unsupported ORM/JPA query methods
    //-------------------------------------------------------------
    @Override
    public Map<String, Object> getHints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ParameterMetadataImplementor getParameterMetadata() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryParameterBindings getParameterBindings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryParameterBindings getQueryParameterBindings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsupportedOperationException parametersNoSupported() {
        return new UnsupportedOperationException("Parameters are not supported in Hibernate Search queries");
    }

    @Override
    public <T> QueryImplementor<T> setTupleTransformer(TupleTransformer<T> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryImplementor<R> setResultListTransformer(ResultListTransformer<R> resultListTransformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsupportedOperationException resultOrTupleTransformerNotImplemented() {
        return new UnsupportedOperationException("Result transformers are not supported in Hibernate Search queries");
    }

    @Override
    public HibernateOrmSearchQueryAdapter<R> setLockMode(LockModeType lockModeType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LockModeType getLockMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(since = "8.0")
    @Override
    @SuppressWarnings("removal")
    public org.hibernate.LockOptions getLockOptions() {
        /*
		 * Ideally we'd throw an UnsupportedOperationException,
		 * but we can't because getLockOptions is called
		 * when AbstractProducedQuery converts exceptions.
		 * So let's just return null, which at least seems acceptable for AbstractProducedQuery.
		 */
        return null;
    }

    private UnsupportedOperationException lockOptionsNotSupported() {
        return new UnsupportedOperationException("Lock options are not supported in Hibernate Search queries");
    }

    @Override
    public int executeUpdate() throws HibernateException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected int doExecuteUpdate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmSearchQueryAdapter<R> setLockMode(String alias, LockMode lockMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Long hintValueToLong(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        } else {
            return Long.parseLong(String.valueOf(value));
        }
    }

    private static Integer hintValueToInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else {
            return Integer.parseInt(String.valueOf(value));
        }
    }

    private static boolean isGraphApplied(MutableQueryOptions queryOptions) {
        final AppliedGraph appliedGraph = queryOptions.getAppliedGraph();
        return appliedGraph != null && appliedGraph.getSemantic() != null;
    }
}
