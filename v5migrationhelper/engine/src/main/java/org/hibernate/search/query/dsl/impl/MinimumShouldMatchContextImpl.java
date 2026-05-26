/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.lang.invoke.MethodHandles;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;

final class MinimumShouldMatchContextImpl {

    private static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    private MinimumShouldMatchConstraint minimumShouldMatchConstraint;

    public void requireNumber(int matchingClausesNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void requirePercent(int matchingClausesPercent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void applyMinimum(BooleanPredicateClausesStep<?, ?> step) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addMinimumShouldMatchConstraint(MinimumShouldMatchConstraint constraint) {
        if (this.minimumShouldMatchConstraint != null) {
            throw log.minimumShouldMatchConflictingConstraints();
        }
        this.minimumShouldMatchConstraint = constraint;
    }

    private static final class MinimumShouldMatchConstraint {

        private final Integer matchingClausesNumber;

        private final Integer matchingClausesPercent;

        MinimumShouldMatchConstraint(Integer matchingClausesNumber, Integer matchingClausesPercent) {
            this.matchingClausesNumber = matchingClausesNumber;
            this.matchingClausesPercent = matchingClausesPercent;
        }

        void apply(BooleanPredicateClausesStep<?, ?> step) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
