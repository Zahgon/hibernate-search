/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.KnnPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.KnnPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.KnnPredicateVectorGenericStep;
import org.hibernate.search.engine.search.predicate.dsl.KnnPredicateVectorStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.KnnPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.reference.predicate.KnnPredicateFieldReference;

public class KnnPredicateFieldStepImpl<SR> extends AbstractPredicateFinalStep implements KnnPredicateFieldStep<SR>, KnnPredicateVectorStep<SR>, KnnPredicateOptionsStep<SR> {

    private final TypedSearchPredicateFactory<SR> factory;

    private final int k;

    private BooleanPredicateBuilder booleanBuilder;

    protected KnnPredicateBuilder builder;

    public KnnPredicateFieldStepImpl(TypedSearchPredicateFactory<SR> factory, SearchPredicateDslContext<?> dslContext, int k) {
        super(dslContext);
        this.factory = factory;
        this.k = k;
    }

    @Override
    public KnnPredicateVectorStep<SR> field(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> KnnPredicateVectorGenericStep<SR, T> field(KnnPredicateFieldReference<? super SR, T> field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> filter(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> filter(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> matching(byte... vector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> matching(float... vector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> requiredMinimumSimilarity(float similarity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> requiredMinimumScore(float score) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateOptionsStep<SR> constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private BooleanPredicateBuilder booleanPredicateBuilder() {
        if (this.booleanBuilder == null) {
            this.booleanBuilder = dslContext.scope().predicateBuilders().bool();
        }
        return this.booleanBuilder;
    }

    private class KnnPredicateVectorGenericStepImpl<T> implements KnnPredicateVectorGenericStep<SR, T> {

        @Override
        public KnnPredicateOptionsStep<SR> matching(T vector) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
