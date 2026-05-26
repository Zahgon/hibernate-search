/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.engine.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.hibernate.search.backend.lucene.LuceneExtension;
import org.hibernate.search.engine.ProjectionConstants;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.SearchProjectionFactory;
import org.hibernate.search.engine.search.query.SearchQuery;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.query.SearchScroll;
import org.hibernate.search.engine.search.query.dsl.SearchQueryOptionsStep;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.spatial.DistanceUnit;
import org.hibernate.search.query.engine.spi.FacetManager;
import org.hibernate.search.query.engine.spi.HSQuery;
import org.hibernate.search.query.engine.spi.TupleTransformer;
import org.hibernate.search.query.engine.spi.V5MigrationSearchSession;
import org.hibernate.search.scope.spi.V5MigrationSearchScope;
import org.hibernate.search.spatial.Coordinates;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;

public class HSQueryImpl<LOS> implements HSQuery {

    private static final String HSEARCH_PROJECTION_FIELD_PREFIX = "__HSearch_";

    private static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    private final V5MigrationSearchScope scope;

    private final V5MigrationSearchSession<LOS> session;

    private final Query query;

    private final Consumer<LOS> loadOptionsContributor;

    private final SearchPredicate predicate;

    private final FacetManagerImpl facetManager;

    private String[] projectedFields;

    private SearchSort sort;

    private Coordinates spatialSearchCenter = null;

    private String spatialFieldName = null;

    private int offset = 0;

    private Integer limit = null;

    private long timeoutValue;

    private TimeUnit timeoutUnit;

    private TimeoutType timeoutType;

    private boolean partialResult;

    private Integer resultSize;

    private TupleTransformer tupleTransformer;

    public HSQueryImpl(V5MigrationSearchScope scope, V5MigrationSearchSession<LOS> session, Query query, Consumer<LOS> loadOptionsContributor) {
        this.scope = scope;
        this.session = session;
        this.query = query;
        this.loadOptionsContributor = loadOptionsContributor;
        this.predicate = scope.predicate().extension(LuceneExtension.get()).fromLuceneQuery(query).toPredicate();
        this.facetManager = new FacetManagerImpl(this);
    }

    @Override
    public HSQuery sort(Sort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HSQuery projection(String... fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HSQuery firstResult(int firstResult) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HSQuery maxResults(Integer maxResults) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer maxResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<Class<?>> getTargetedEntities() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String[] getProjectedFields() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void failAfter(Long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void failAfter(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void truncateAfter(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetManager getFacetManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query getLuceneQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<?> fetch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasPartialResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getResultSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchScroll<?> scroll(int chunkSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Explanation explain(Object entityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HSQuery setSpatialParameters(Coordinates center, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HSQuery tupleTransformer(TupleTransformer tupleTransformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    List<?> doFetch(int offset, Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SearchQuery<?> createSearchQuery() {
        SearchProjection<?> projection = createCompositeProjection();
        if (sort == null) {
            sort = scope.sort().score().toSort();
        }
        SearchQueryOptionsStep<?, ?, ?, LOS, ?, ?> optionsStep = session.search(scope).select(projection).where(predicate).sort(sort);
        if (loadOptionsContributor != null) {
            optionsStep = optionsStep.loading(loadOptionsContributor);
        }
        if (timeoutType != null) {
            switch(timeoutType) {
                case FAIL:
                    optionsStep.failAfter(timeoutValue, timeoutUnit);
                    break;
                case TRUNCATE:
                    optionsStep.truncateAfter(timeoutValue, timeoutUnit);
                    break;
            }
        }
        optionsStep = facetManager.contributeAggregations(optionsStep);
        return optionsStep.toQuery();
    }

    private SearchProjection<?> createCompositeProjection() {
        SearchProjectionFactory<?, ?> factory = scope.projection();
        if (projectedFields == null || projectedFields.length == 0) {
            // No tuple, so we ignore the tupleTransformer (Search 5 behavior)
            return factory.entity().toProjection();
        }
        SearchProjection<?>[] projections = new SearchProjection[projectedFields.length];
        for (int i = 0; i < projectedFields.length; i++) {
            projections[i] = createProjection(projectedFields[i]);
        }
        if (tupleTransformer != null) {
            return factory.composite().from(projections).asArray(array -> tupleTransformer.transform(array, projectedFields)).toProjection();
        } else {
            return factory.composite().from(projections).asArray().toProjection();
        }
    }

    private SearchProjection<?> createProjection(String field) {
        SearchProjectionFactory<?, ?> factory = scope.projection();
        if (field == null) {
            // Hack to return null when a null field name is requested,
            // which is what Search 5 used to do...
            return factory.composite().from(factory.documentReference()).as(ignored -> null).toProjection();
        }
        switch(field) {
            case ProjectionConstants.THIS:
                return factory.entity().toProjection();
            case ProjectionConstants.DOCUMENT:
                return factory.extension(LuceneExtension.get()).document().toProjection();
            case ProjectionConstants.SCORE:
                return factory.score().toProjection();
            case ProjectionConstants.ID:
                return scope.idProjection();
            case ProjectionConstants.EXPLANATION:
                return factory.extension(LuceneExtension.get()).explanation().toProjection();
            case ProjectionConstants.OBJECT_CLASS:
                return scope.objectClassProjection();
            case ProjectionConstants.SPATIAL_DISTANCE:
                return factory.distance(spatialFieldName, Coordinates.toGeoPoint(spatialSearchCenter)).unit(DistanceUnit.KILOMETERS).toProjection();
            default:
                if (field.startsWith(HSEARCH_PROJECTION_FIELD_PREFIX)) {
                    throw log.unexpectedProjectionConstant(field);
                }
                return factory.field(field).toProjection();
        }
    }

    private enum TimeoutType {

        FAIL, TRUNCATE
    }
}
