/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.NestedPredicateNestStep;
import org.hibernate.search.engine.search.predicate.dsl.NestedPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.NestedPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;

@Deprecated(since = "6.2")
public final class NestedPredicateFieldStepImpl<SR> extends AbstractPredicateFinalStep implements org.hibernate.search.engine.search.predicate.dsl.NestedPredicateFieldStep<SR, NestedPredicateNestStep<SR, ?>>, org.hibernate.search.engine.search.predicate.dsl.NestedPredicateNestStep<SR, NestedPredicateOptionsStep<?>>, org.hibernate.search.engine.search.predicate.dsl.NestedPredicateOptionsStep<org.hibernate.search.engine.search.predicate.dsl.NestedPredicateOptionsStep<?>> {

    private final TypedSearchPredicateFactory<SR> factory;

    private NestedPredicateBuilder builder;

    public NestedPredicateFieldStepImpl(SearchPredicateDslContext<?> dslContext, TypedSearchPredicateFactory<SR> factory) {
        super(dslContext);
        this.factory = factory;
    }

    @Override
    public org.hibernate.search.engine.search.predicate.dsl.NestedPredicateNestStep<SR, ?> objectField(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public org.hibernate.search.engine.search.predicate.dsl.NestedPredicateOptionsStep<?> nest(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public org.hibernate.search.engine.search.predicate.dsl.NestedPredicateOptionsStep<?> nest(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> predicateContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
