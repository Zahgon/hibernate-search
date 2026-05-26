/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import org.hibernate.search.engine.search.predicate.dsl.MinimumShouldMatchConditionStep;
import org.hibernate.search.engine.search.predicate.dsl.MinimumShouldMatchMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.MinimumShouldMatchRequireStep;
import org.hibernate.search.engine.search.predicate.spi.MinimumShouldMatchBuilder;
import org.hibernate.search.util.common.impl.Contracts;

final class MinimumShouldMatchConditionStepImpl<N> implements MinimumShouldMatchConditionStep<N>, MinimumShouldMatchRequireStep<N>, MinimumShouldMatchMoreStep<N> {

    private final MinimumShouldMatchBuilder builder;

    private final N nextStep;

    private int ignoreConstraintCeiling = 0;

    MinimumShouldMatchConditionStepImpl(MinimumShouldMatchBuilder builder, N nextStep) {
        this.builder = builder;
        this.nextStep = nextStep;
    }

    @Override
    public MinimumShouldMatchRequireStep<N> ifMoreThan(int ignoreConstraintCeiling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MinimumShouldMatchMoreStep<N> thenRequireNumber(int matchingClausesNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MinimumShouldMatchMoreStep<N> thenRequirePercent(int matchingClausesPercent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public N end() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
