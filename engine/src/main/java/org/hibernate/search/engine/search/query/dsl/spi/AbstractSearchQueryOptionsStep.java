/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.query.dsl.spi;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.AggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.engine.search.highlighter.SearchHighlighter;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterFinalStep;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleBooleanPredicateClausesCollector;
import org.hibernate.search.engine.search.predicate.dsl.SimpleBooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.query.SearchQuery;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.query.SearchScroll;
import org.hibernate.search.engine.search.query.dsl.SearchQueryOptionsStep;
import org.hibernate.search.engine.search.query.dsl.SearchQueryWhereStep;
import org.hibernate.search.engine.search.query.spi.SearchQueryBuilder;
import org.hibernate.search.engine.search.query.spi.SearchQueryIndexScope;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SortFinalStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;

public abstract class AbstractSearchQueryOptionsStep<SR, S extends SearchQueryOptionsStep<SR, S, H, LOS, SF, AF>, H, LOS, PDF extends TypedSearchPredicateFactory<SR>, SF extends TypedSearchSortFactory<SR>, AF extends TypedSearchAggregationFactory<SR>, SC extends SearchQueryIndexScope<SR, ?>> implements SearchQueryWhereStep<SR, S, H, LOS, PDF>, SearchQueryOptionsStep<SR, S, H, LOS, SF, AF> {

    protected final SC scope;

    private final SearchQueryBuilder<H> searchQueryBuilder;

    private final SearchLoadingContextBuilder<?, LOS> loadingContextBuilder;

    public AbstractSearchQueryOptionsStep(SC scope, SearchQueryBuilder<H> searchQueryBuilder, SearchLoadingContextBuilder<?, LOS> loadingContextBuilder) {
        this.scope = scope;
        this.searchQueryBuilder = searchQueryBuilder;
        this.loadingContextBuilder = loadingContextBuilder;
    }

    @Override
    public S where(SearchPredicate predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S where(Function<? super PDF, ? extends PredicateFinalStep> predicateContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S where(BiConsumer<? super PDF, ? super SimpleBooleanPredicateClausesCollector<SR, ?>> predicateContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S routing(String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S routing(Collection<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S truncateAfter(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S failAfter(long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S totalHitCountThreshold(long totalHitCountThreshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S highlighter(Function<? super SearchHighlighterFactory, ? extends HighlighterFinalStep> highlighterContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S highlighter(SearchHighlighter highlighter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S highlighter(String highlighterName, Function<? super SearchHighlighterFactory, ? extends HighlighterFinalStep> highlighterContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S highlighter(String highlighterName, SearchHighlighter highlighter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S loading(Consumer<? super LOS> loadingOptionsContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S sort(SearchSort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S sort(Function<? super SF, ? extends SortFinalStep> sortContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A> S aggregation(AggregationKey<A> key, SearchAggregation<A> aggregation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A> S aggregation(AggregationKey<A> key, Function<? super AF, ? extends AggregationFinalStep<A>> aggregationContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S param(String parameterName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchQuery<H> toQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchResult<H> fetchAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchResult<H> fetch(Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchResult<H> fetch(Integer offset, Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<H> fetchAllHits() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<H> fetchHits(Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<H> fetchHits(Integer offset, Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<H> fetchSingleHit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long fetchTotalHitCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchScroll<H> scroll(int chunkSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract S thisAsS();

    protected abstract PDF predicateFactory();

    protected abstract SF sortFactory();

    protected abstract AF aggregationFactory();

    protected abstract SearchHighlighterFactory highlighterFactory();
}
