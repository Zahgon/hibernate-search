/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.engine.search.predicate.spi.MinimumShouldMatchBuilder;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;

public final class LuceneCommonMinimumShouldMatchConstraints implements MinimumShouldMatchBuilder {

    private NavigableMap<Integer, MinimumShouldMatchConstraint> minimumShouldMatchConstraints;

    @Override
    public void minimumShouldMatchNumber(int ignoreConstraintCeiling, int matchingClausesNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void minimumShouldMatchPercent(int ignoreConstraintCeiling, int matchingClausesPercent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addMinimumShouldMatchConstraint(int ignoreConstraintCeiling, MinimumShouldMatchConstraint constraint) {
        if (minimumShouldMatchConstraints == null) {
            // We'll need to go through the data in ascending order, so use a TreeMap
            minimumShouldMatchConstraints = new TreeMap<>();
        }
        Object previous = minimumShouldMatchConstraints.put(ignoreConstraintCeiling, constraint);
        if (previous != null) {
            throw QueryLog.INSTANCE.minimumShouldMatchConflictingConstraints(ignoreConstraintCeiling);
        }
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int minimumShouldMatch(Collection<?> shouldClauses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int minimumShouldMatch(int shouldClauses) {
        Map.Entry<Integer, MinimumShouldMatchConstraint> entry = minimumShouldMatchConstraints.lowerEntry(shouldClauses);
        if (entry != null) {
            return entry.getValue().toMinimum(shouldClauses);
        } else {
            return shouldClauses;
        }
    }

    public Query apply(Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class MinimumShouldMatchConstraint {

        private final Integer matchingClausesNumber;

        private final Integer matchingClausesPercent;

        MinimumShouldMatchConstraint(Integer matchingClausesNumber, Integer matchingClausesPercent) {
            this.matchingClausesNumber = matchingClausesNumber;
            this.matchingClausesPercent = matchingClausesPercent;
        }

        int toMinimum(int totalShouldClauseNumber) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
