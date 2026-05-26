/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.query.dsl.impl;

import org.hibernate.search.backend.elasticsearch.search.aggregation.dsl.ElasticsearchSearchAggregationFactory;
import org.hibernate.search.backend.elasticsearch.search.predicate.dsl.ElasticsearchSearchPredicateFactory;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchQuery;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchRequestTransformer;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchResult;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchScroll;
import org.hibernate.search.backend.elasticsearch.search.query.dsl.ElasticsearchSearchQueryOptionsStep;
import org.hibernate.search.backend.elasticsearch.search.query.dsl.ElasticsearchSearchQueryWhereStep;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchQueryBuilder;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchQueryIndexScope;
import org.hibernate.search.backend.elasticsearch.search.sort.dsl.ElasticsearchSearchSortFactory;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.query.dsl.spi.AbstractExtendedSearchQueryOptionsStep;

class ElasticsearchSearchQueryOptionsStepImpl<SR, H, LOS> extends AbstractExtendedSearchQueryOptionsStep<SR, ElasticsearchSearchQueryOptionsStep<SR, H, LOS>, H, ElasticsearchSearchResult<H>, ElasticsearchSearchScroll<H>, LOS, ElasticsearchSearchPredicateFactory<SR>, ElasticsearchSearchSortFactory<SR>, ElasticsearchSearchAggregationFactory<SR>, ElasticsearchSearchQueryIndexScope<SR, ?>> implements ElasticsearchSearchQueryWhereStep<SR, H, LOS>, ElasticsearchSearchQueryOptionsStep<SR, H, LOS> {

    private final ElasticsearchSearchQueryBuilder<H> searchQueryBuilder;

    ElasticsearchSearchQueryOptionsStepImpl(ElasticsearchSearchQueryIndexScope<SR, ?> scope, ElasticsearchSearchQueryBuilder<H> searchQueryBuilder, SearchLoadingContextBuilder<?, LOS> loadingContextBuilder) {
        super(scope, searchQueryBuilder, loadingContextBuilder);
        this.searchQueryBuilder = searchQueryBuilder;
    }

    @Override
    public ElasticsearchSearchQueryOptionsStep<SR, H, LOS> requestTransformer(ElasticsearchSearchRequestTransformer transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchQuery<H> toQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchQueryOptionsStepImpl<SR, H, LOS> thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchPredicateFactory<SR> predicateFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchSortFactory<SR> sortFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchAggregationFactory<SR> aggregationFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchHighlighterFactory highlighterFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
