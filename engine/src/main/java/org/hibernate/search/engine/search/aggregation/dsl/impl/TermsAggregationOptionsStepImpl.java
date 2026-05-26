/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import java.util.Map;
import java.util.function.Function;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.TermsAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.TermsAggregationValueStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.TermsAggregationBuilder;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.util.common.impl.Contracts;

class TermsAggregationOptionsStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>, F, V> implements TermsAggregationValueStep<SR, TermsAggregationOptionsStepImpl<SR, PDF, F, V>, PDF, F, Map<F, V>> {

    private final TermsAggregationBuilder<F, V> builder;

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    TermsAggregationOptionsStepImpl(TermsAggregationBuilder<F, V> builder, SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.builder = builder;
        this.dslContext = dslContext;
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> orderByCountDescending() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> orderByCountAscending() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> orderByTermAscending() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> orderByTermDescending() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> minDocumentCount(int minDocumentCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> maxTermCount(int maxTermCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> filter(Function<? super PDF, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationOptionsStepImpl<SR, PDF, F, V> filter(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchAggregation<Map<F, V>> toAggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TermsAggregationOptionsStep<SR, ?, PDF, F, Map<F, T>> value(SearchAggregation<T> aggregation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
