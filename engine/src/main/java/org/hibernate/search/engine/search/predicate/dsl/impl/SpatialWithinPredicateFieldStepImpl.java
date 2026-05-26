/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.search.engine.search.predicate.dsl.SpatialWithinPredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.SpatialWithinPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.reference.predicate.SpatialPredicateFieldReference;

class SpatialWithinPredicateFieldStepImpl<SR> implements SpatialWithinPredicateFieldStep<SR, SpatialWithinPredicateFieldMoreStep<SR, ?, ?>> {

    private final SpatialWithinPredicateFieldMoreStepImpl.CommonState<SR> commonState;

    SpatialWithinPredicateFieldStepImpl(SearchPredicateDslContext<?> dslContext) {
        this.commonState = new SpatialWithinPredicateFieldMoreStepImpl.CommonState<>(dslContext);
    }

    @Override
    public SpatialWithinPredicateFieldMoreStep<SR, ?, ?> fields(String... fieldPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public SpatialWithinPredicateFieldMoreStep<SR, ?, ?> fields(SpatialPredicateFieldReference<? super SR>... fieldReferences) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
