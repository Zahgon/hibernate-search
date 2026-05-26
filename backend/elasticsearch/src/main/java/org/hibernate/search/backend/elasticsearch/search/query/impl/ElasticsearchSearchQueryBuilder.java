/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.query.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchParallelWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchSearchAggregation;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.highlighter.impl.ElasticsearchSearchHighlighter;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchSearchPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.DistanceSortKey;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchSearchProjection;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchQuery;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchRequestTransformer;
import org.hibernate.search.backend.elasticsearch.search.sort.impl.ElasticsearchSearchSort;
import org.hibernate.search.backend.elasticsearch.search.sort.impl.ElasticsearchSearchSortCollector;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import org.hibernate.search.backend.elasticsearch.work.impl.ElasticsearchSearchResultExtractor;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.highlighter.SearchHighlighter;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.query.spi.QueryParameters;
import org.hibernate.search.engine.search.query.spi.SearchQueryBuilder;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.common.impl.CollectionHelper;
import org.hibernate.search.util.common.impl.Contracts;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ElasticsearchSearchQueryBuilder<H> implements SearchQueryBuilder<H>, ElasticsearchSearchSortCollector {

    private static final JsonAccessor<JsonElement> REQUEST_SOURCE_ACCESSOR = JsonAccessor.root().property("_source");

    private final ElasticsearchWorkFactory workFactory;

    private final ElasticsearchSearchResultExtractorFactory searchResultExtractorFactory;

    private final ElasticsearchParallelWorkOrchestrator queryOrchestrator;

    private final ElasticsearchSearchIndexScope<?> scope;

    private final BackendSessionContext sessionContext;

    private final PredicateRequestContext rootPredicateContext;

    private final SearchLoadingContextBuilder<?, ?> loadingContextBuilder;

    private final ElasticsearchSearchProjection<H> rootProjection;

    private final Integer scrollTimeout;

    private final Set<String> routingKeys;

    private ElasticsearchSearchPredicate elasticsearchPredicate;

    private JsonArray jsonSort;

    private List<ElasticsearchSearchSort> elasticsearchSearchSorts;

    private Map<DistanceSortKey, Integer> distanceSorts;

    private Map<AggregationKey<?>, ElasticsearchSearchAggregation<?>> aggregations;

    private Long timeoutValue;

    private TimeUnit timeoutUnit;

    private boolean exceptionOnTimeout;

    private Long totalHitCountThreshold;

    private ElasticsearchSearchHighlighter queryHighlighter;

    private final Map<String, ElasticsearchSearchHighlighter> namedHighlighters = new HashMap<>();

    private final QueryParameters parameters = new QueryParameters();

    private ElasticsearchSearchRequestTransformer requestTransformer;

    public ElasticsearchSearchQueryBuilder(ElasticsearchWorkFactory workFactory, ElasticsearchSearchResultExtractorFactory searchResultExtractorFactory, ElasticsearchParallelWorkOrchestrator queryOrchestrator, ElasticsearchSearchIndexScope<?> scope, BackendSessionContext sessionContext, SearchLoadingContextBuilder<?, ?> loadingContextBuilder, ElasticsearchSearchProjection<H> rootProjection, Integer scrollTimeout) {
        this.workFactory = workFactory;
        this.searchResultExtractorFactory = searchResultExtractorFactory;
        this.queryOrchestrator = queryOrchestrator;
        this.scope = scope;
        this.sessionContext = sessionContext;
        this.routingKeys = new HashSet<>();
        this.rootPredicateContext = new PredicateRequestContext(sessionContext, scope, routingKeys, parameters);
        this.loadingContextBuilder = loadingContextBuilder;
        this.rootProjection = rootProjection;
        this.scrollTimeout = scrollTimeout;
    }

    @Override
    public void predicate(SearchPredicate predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void sort(SearchSort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A> void aggregation(AggregationKey<A> key, SearchAggregation<A> aggregation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addRoutingKey(String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void truncateAfter(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void failAfter(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void totalHitCountThreshold(long totalHitCountThreshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void highlighter(SearchHighlighter queryHighlighter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void highlighter(String highlighterName, SearchHighlighter highlighter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void param(String parameterName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateRequestContext getRootPredicateContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void collectSort(JsonElement sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void collectDistanceSort(JsonElement sort, String absoluteFieldPath, GeoPoint center) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void requestTransformer(ElasticsearchSearchRequestTransformer transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchQuery<H> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
