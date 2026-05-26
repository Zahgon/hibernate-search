/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.query.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSyncWorkOrchestrator;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.aggregation.impl.RootAggregationRequestContext;
import org.hibernate.search.backend.lucene.search.extraction.impl.ExtractionRequirements;
import org.hibernate.search.backend.lucene.search.highlighter.impl.LuceneAbstractSearchHighlighter;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection;
import org.hibernate.search.backend.lucene.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.backend.lucene.search.query.LuceneSearchQuery;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSort;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSortCollector;
import org.hibernate.search.backend.lucene.work.impl.LuceneWorkFactory;
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
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;

public class LuceneSearchQueryBuilder<H> implements SearchQueryBuilder<H>, LuceneSearchSortCollector {

    private final LuceneWorkFactory workFactory;

    private final LuceneSyncWorkOrchestrator queryOrchestrator;

    private final LuceneSearchQueryIndexScope<?, ?> scope;

    private final BackendSessionContext sessionContext;

    private final Set<String> routingKeys;

    private final SearchLoadingContextBuilder<?, ?> loadingContextBuilder;

    private final LuceneSearchProjection<H> rootProjection;

    private LuceneSearchPredicate lucenePredicate;

    private List<SortField> sortFields;

    private List<LuceneSearchSort> luceneSearchSorts;

    private Map<AggregationKey<?>, LuceneSearchAggregation<?>> aggregations;

    private Long timeout;

    private TimeUnit timeUnit;

    private boolean exceptionOnTimeout;

    private Long totalHitCountThreshold;

    private LuceneAbstractSearchHighlighter globalHighlighter;

    private final Map<String, LuceneAbstractSearchHighlighter> namedHighlighters = new HashMap<>();

    private final QueryParameters parameters = new QueryParameters();

    public LuceneSearchQueryBuilder(LuceneWorkFactory workFactory, LuceneSyncWorkOrchestrator queryOrchestrator, LuceneSearchQueryIndexScope<?, ?> scope, BackendSessionContext sessionContext, SearchLoadingContextBuilder<?, ?> loadingContextBuilder, LuceneSearchProjection<H> rootProjection) {
        this.workFactory = workFactory;
        this.queryOrchestrator = queryOrchestrator;
        this.scope = scope;
        this.sessionContext = sessionContext;
        this.routingKeys = new HashSet<>();
        this.loadingContextBuilder = loadingContextBuilder;
        this.rootProjection = rootProjection;
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
    public void collectSortField(SortField sortField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void collectSortFields(SortField[] sortFields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateRequestContext toPredicateRequestContext(String absoluteNestedPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchQuery<H> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
