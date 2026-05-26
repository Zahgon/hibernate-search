/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.scope.model.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.lucene.search.aggregation.dsl.LuceneSearchAggregationFactory;
import org.hibernate.search.backend.lucene.search.aggregation.dsl.impl.LuceneSearchAggregationFactoryImpl;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregationBuilderFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneMultiIndexSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneMultiIndexSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.highlighter.impl.LuceneSearchHighlighterFactory;
import org.hibernate.search.backend.lucene.search.predicate.dsl.LuceneSearchPredicateFactory;
import org.hibernate.search.backend.lucene.search.predicate.dsl.impl.LuceneSearchPredicateFactoryImpl;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicateBuilderFactory;
import org.hibernate.search.backend.lucene.search.projection.dsl.LuceneSearchProjectionFactory;
import org.hibernate.search.backend.lucene.search.projection.dsl.impl.LuceneSearchProjectionFactoryImpl;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjectionBuilderFactory;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryBuilder;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryIndexScope;
import org.hibernate.search.backend.lucene.search.query.impl.SearchBackendContext;
import org.hibernate.search.backend.lucene.search.sort.dsl.LuceneSearchSortFactory;
import org.hibernate.search.backend.lucene.search.sort.dsl.impl.LuceneSearchSortFactoryImpl;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSortBuilderFactory;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.scope.spi.AbstractSearchIndexScope;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.spi.SearchProjectionDslContext;
import org.hibernate.search.engine.search.sort.dsl.spi.SearchSortDslContext;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.apache.lucene.search.Query;

public final class LuceneSearchIndexScopeImpl<SR> extends AbstractSearchIndexScope<SR, LuceneSearchIndexScopeImpl<SR>, LuceneIndexModel, LuceneSearchIndexNodeContext, LuceneSearchIndexCompositeNodeContext> implements LuceneSearchIndexScope<LuceneSearchIndexScopeImpl<SR>>, LuceneSearchQueryIndexScope<SR, LuceneSearchIndexScopeImpl<SR>> {

    // Backend context
    private final SearchBackendContext backendContext;

    private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

    private final MultiTenancyStrategy multiTenancyStrategy;

    // Global timing source
    private final TimingSource timingSource;

    // Targeted indexes
    private final Map<String, LuceneScopeIndexManagerContext> mappedTypeNameToIndex;

    // Query support
    private final LuceneSearchPredicateBuilderFactory predicateBuilderFactory;

    private final LuceneSearchSortBuilderFactory sortBuilderFactory;

    private final LuceneSearchProjectionBuilderFactory projectionBuilderFactory;

    private final LuceneSearchAggregationBuilderFactory aggregationBuilderFactory;

    public LuceneSearchIndexScopeImpl(BackendMappingContext mappingContext, Class<SR> rootScopeType, SearchBackendContext backendContext, LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry, MultiTenancyStrategy multiTenancyStrategy, TimingSource timingSource, Set<? extends LuceneScopeIndexManagerContext> indexManagerContexts) {
        super(mappingContext, rootScopeType, toModels(indexManagerContexts));
        this.backendContext = backendContext;
        this.analysisDefinitionRegistry = analysisDefinitionRegistry;
        this.multiTenancyStrategy = multiTenancyStrategy;
        this.timingSource = timingSource;
        // Use LinkedHashMap/LinkedHashSet to ensure stable order when generating requests
        this.mappedTypeNameToIndex = new LinkedHashMap<>();
        for (LuceneScopeIndexManagerContext indexManager : indexManagerContexts) {
            this.mappedTypeNameToIndex.put(indexManager.model().mappedTypeName(), indexManager);
        }
        this.predicateBuilderFactory = new LuceneSearchPredicateBuilderFactory(this);
        this.sortBuilderFactory = new LuceneSearchSortBuilderFactory(this);
        this.projectionBuilderFactory = new LuceneSearchProjectionBuilderFactory(this);
        this.aggregationBuilderFactory = new LuceneSearchAggregationBuilderFactory(this);
    }

    private LuceneSearchIndexScopeImpl(LuceneSearchIndexScopeImpl<SR> parentScope, LuceneSearchIndexCompositeNodeContext overriddenRoot) {
        super(parentScope, overriddenRoot);
        this.backendContext = parentScope.backendContext;
        this.analysisDefinitionRegistry = parentScope.analysisDefinitionRegistry;
        this.multiTenancyStrategy = parentScope.multiTenancyStrategy;
        this.timingSource = parentScope.timingSource;
        this.mappedTypeNameToIndex = parentScope.mappedTypeNameToIndex;
        this.predicateBuilderFactory = new LuceneSearchPredicateBuilderFactory(this);
        this.sortBuilderFactory = new LuceneSearchSortBuilderFactory(this);
        this.projectionBuilderFactory = new LuceneSearchProjectionBuilderFactory(this);
        this.aggregationBuilderFactory = new LuceneSearchAggregationBuilderFactory(this);
    }

    private static Set<? extends LuceneIndexModel> toModels(Set<? extends LuceneScopeIndexManagerContext> indexManagerContexts) {
        return indexManagerContexts.stream().map(LuceneScopeIndexManagerContext::model).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    protected LuceneSearchIndexScopeImpl<SR> self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchIndexScopeImpl<SR> withRoot(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchPredicateBuilderFactory predicateBuilders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchSortBuilderFactory sortBuilders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchProjectionBuilderFactory projectionBuilders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchAggregationBuilderFactory aggregationBuilders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <P> LuceneSearchQueryBuilder<P> select(BackendSessionContext sessionContext, SearchLoadingContextBuilder<?, ?> loadingContextBuilder, SearchProjection<P> projection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchPredicateFactory<SR> predicateFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchSortFactory<SR> sortFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R, E> LuceneSearchProjectionFactory<SR, R, E> projectionFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchAggregationFactory<SR> aggregationFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchHighlighterFactory highlighterFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query filterOrNull(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TimeoutManager createTimeoutManager(Long timeout, TimeUnit timeUnit, boolean exceptionOnTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<LuceneScopeIndexManagerContext> indexes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, ? extends LuceneSearchIndexContext> mappedTypeNameToIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasNestedDocuments() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneSearchIndexCompositeNodeContext createMultiIndexSearchRootContext(List<LuceneSearchIndexCompositeNodeContext> rootForEachIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected LuceneSearchIndexNodeContext createMultiIndexSearchValueFieldContext(String absolutePath, List<LuceneSearchIndexNodeContext> fieldForEachIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected LuceneSearchIndexNodeContext createMultiIndexSearchObjectFieldContext(String absolutePath, List<LuceneSearchIndexNodeContext> fieldForEachIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
