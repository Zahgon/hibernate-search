/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.ExistsPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.ExistsPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.ExistsPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;

public final class ExistsPredicateFieldStepImpl<SR> extends AbstractPredicateFinalStep implements ExistsPredicateFieldStep<SR, ExistsPredicateOptionsStep<?>>, ExistsPredicateOptionsStep<ExistsPredicateOptionsStep<?>> {

    private ExistsPredicateBuilder builder;

    public ExistsPredicateFieldStepImpl(SearchPredicateDslContext<?> dslContext) {
        super(dslContext);
    }

    @Override
    public ExistsPredicateOptionsStep<?> field(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ExistsPredicateOptionsStep<?> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ExistsPredicateOptionsStep<?> constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
