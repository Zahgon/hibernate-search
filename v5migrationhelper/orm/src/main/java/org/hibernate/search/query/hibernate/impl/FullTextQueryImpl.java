/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.hibernate.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.QueryTimeoutException;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.TypeMismatchException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.graph.GraphSemantic;
import org.hibernate.graph.RootGraph;
import org.hibernate.graph.spi.RootGraphImplementor;
import org.hibernate.query.IllegalQueryOperationException;
import org.hibernate.query.KeyedPage;
import org.hibernate.query.KeyedResultList;
import org.hibernate.query.spi.AbstractQuery;
import org.hibernate.query.spi.MutableQueryOptions;
import org.hibernate.query.spi.ParameterMetadataImplementor;
import org.hibernate.query.spi.QueryImplementor;
import org.hibernate.query.spi.QueryParameterBindings;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.engine.search.query.SearchScroll;
import org.hibernate.search.impl.V5MigrationOrmSearchIntegratorAdapter;
import org.hibernate.search.mapper.orm.search.loading.EntityLoadingCacheLookupStrategy;
import org.hibernate.search.mapper.orm.search.loading.dsl.SearchLoadingOptionsStep;
import org.hibernate.search.mapper.orm.search.query.spi.HibernateOrmSearchQueryHints;
import org.hibernate.search.mapper.orm.search.query.spi.HibernateOrmSearchScrollableResultsAdapter;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.engine.spi.FacetManager;
import org.hibernate.search.query.engine.spi.HSQuery;
import org.hibernate.search.query.engine.spi.V5MigrationSearchSession;
import org.hibernate.search.spatial.Coordinates;
import org.hibernate.search.spatial.impl.Point;
import org.hibernate.search.util.common.SearchTimeoutException;
import org.hibernate.transform.ResultTransformer;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;

/**
 * Implementation of {@link org.hibernate.search.FullTextQuery}.
 *
 * @author Emmanuel Bernard
 * @author Hardy Ferentschik
 */
// We extend the raw version of AbstractProducedQuery on purpose, see HSEARCH-2564
@SuppressWarnings("rawtypes")
public class FullTextQueryImpl extends AbstractQuery implements FullTextQuery {

    private final V5MigrationSearchSession<SearchLoadingOptionsStep> searchSession;

    private final HSQuery hSearchQuery;

    //initialized at 0 since we don't expect to use hints at this stage
    private final Map<String, Object> hints = new HashMap<String, Object>(0);

    private Integer fetchSize = null;

    private EntityLoadingCacheLookupStrategy cacheLookupStrategy = null;

    private List<EntityGraphHint> entityGraphHints = new ArrayList<>();

    private final Consumer<SearchLoadingOptionsStep> loadingOptionsContributor = o -> {
        if (cacheLookupStrategy != null) {
            o.cacheLookupStrategy(cacheLookupStrategy);
        }
        if (fetchSize != null) {
            o.fetchSize(fetchSize);
        }
        for (EntityGraphHint hint : entityGraphHints) {
            o.graph(hint.graph, hint.semantic);
        }
    };

    private ResultTransformer resultTransformer;

    public FullTextQueryImpl(Query luceneQuery, SessionImplementor sessionImplementor, V5MigrationOrmSearchIntegratorAdapter searchIntegrator, V5MigrationSearchSession<SearchLoadingOptionsStep> searchSession, Class<?>... entities) {
        super(sessionImplementor);
        this.searchSession = searchSession;
        this.hSearchQuery = searchIntegrator.createHSQuery(luceneQuery, searchSession, loadingOptionsContributor, entities);
    }

    @Override
    public FullTextQueryImpl setSort(Sort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List getResultList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScrollableResultsImplementor scroll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getResultCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyedResultList getKeyedResultList(KeyedPage page) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsupportedOperationException keyedResultListNoSupported() {
        return new UnsupportedOperationException("Keyed result lists are not supported in Hibernate Search queries");
    }

    @Override
    protected ScrollableResultsImplementor doScroll(ScrollMode scrollMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List list() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected List doList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void beforeQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void extractQueryOptions() {
        MutableQueryOptions queryOptions = getQueryOptions();
        Integer limit = queryOptions.getLimit().getMaxRows();
        hSearchQuery.maxResults(limit);
        Integer offset = queryOptions.getLimit().getFirstRow();
        hSearchQuery.firstResult(offset == null ? 0 : offset);
        Integer queryFetchSize = queryOptions.getFetchSize();
        if (queryFetchSize != null) {
            fetchSize = queryFetchSize;
        }
        Integer queryTimeout = queryOptions.getTimeout();
        if (queryTimeout != null) {
            hSearchQuery.failAfter(queryTimeout, TimeUnit.SECONDS);
        }
    }

    @Override
    public Explanation explain(Object entityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getResultSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int doGetResultSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQuery applyGraph(RootGraph graph, GraphSemantic semantic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void applyGraph(RootGraphImplementor<?> graph, GraphSemantic semantic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setProjection(String... fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setSpatialParameters(Coordinates center, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setSpatialParameters(double latitude, double longitude, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQuery setMaxResults(int maxResults) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQuery setFirstResult(int firstResult) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("deprecation")
    public FullTextQuery setHint(String hintName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

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
    public FullTextQueryImpl setFlushMode(FlushModeType flushModeType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setFetchSize(int fetchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(since = "8.2", forRemoval = true)
    @Override
    public QueryImplementor setLockOptions(org.hibernate.LockOptions lockOptions) {
        throw lockOptionsNotSupported();
    }

    @Deprecated
    @Override
    public FullTextQueryImpl setResultTransformer(ResultTransformer transformer) {
        resultTransformer = transformer;
        if (transformer != null) {
            hSearchQuery.tupleTransformer((tuple, fields) -> resultTransformer.transformTuple(tuple, fields));
        } else {
            hSearchQuery.tupleTransformer(null);
        }
        return this;
    }

    /*
	 * Implementation note: this method is defined as generic in the interface,
	 * but we must implement it without generics (otherwise it won't compile).
	 *
	 * The actual reason is a bit hard to explain: basically we implement
	 * jakarta.persistence.Query as a raw type at some point, and our superclass
	 * (also extended as a raw type) also implements this interface, but as a non-raw type.
	 * This seems to confuse the compiler, which thinks there are two different methods.
	 */
    @Override
    @SuppressWarnings("unchecked")
    public Object unwrap(Class type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setLockMode(LockModeType lockModeType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LockModeType getLockMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(since = "8.2", forRemoval = true)
    @Override
    public org.hibernate.LockOptions getLockOptions() {
        throw lockOptionsNotSupported();
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
    public QueryImplementor setLockMode(String alias, LockMode lockMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetManager getFacetManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setTimeout(Integer timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setTimeout(int timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl setTimeout(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl limitExecutionTimeTo(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasPartialResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextQueryImpl initializeObjectsWith(ObjectLookupMethod lookupMethod, DatabaseRetrievalMethod retrievalMethod) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class Search5ScrollHitExtractor implements Function<Object, Object[]> {

        private static final Search5ScrollHitExtractor INSTANCE = new Search5ScrollHitExtractor();

        @Override
        public Object[] apply(Object hit) {
            throw new UnsupportedOperationException("STUB: not implemented");
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

    private static RootGraphImplementor<?> hintValueToEntityGraph(Object value) {
        return (RootGraphImplementor) value;
    }
}
