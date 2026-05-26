/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.engine.search.predicate.spi.MinimumShouldMatchBuilder;

public final class ElasticsearchCommonMinimumShouldMatchConstraints implements MinimumShouldMatchBuilder {

    private Map<Integer, CommonMinimumShouldMatchConstraint> minimumShouldMatchConstraints;

    @Override
    public void minimumShouldMatchNumber(int ignoreConstraintCeiling, int matchingClausesNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void minimumShouldMatchPercent(int ignoreConstraintCeiling, int matchingClausesPercent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addMinimumShouldMatchConstraint(int ignoreConstraintCeiling, CommonMinimumShouldMatchConstraint constraint) {
        if (minimumShouldMatchConstraints == null) {
            // We'll need to go through the data in ascending order, so use a TreeMap
            minimumShouldMatchConstraints = new TreeMap<>();
        }
        Object previous = minimumShouldMatchConstraints.put(ignoreConstraintCeiling, constraint);
        if (previous != null) {
            throw QueryLog.INSTANCE.minimumShouldMatchConflictingConstraints(ignoreConstraintCeiling);
        }
    }

    public String formatMinimumShouldMatchConstraints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class CommonMinimumShouldMatchConstraint {

        private final Integer matchingClausesNumber;

        private final Integer matchingClausesPercent;

        CommonMinimumShouldMatchConstraint(Integer matchingClausesNumber, Integer matchingClausesPercent) {
            this.matchingClausesNumber = matchingClausesNumber;
            this.matchingClausesPercent = matchingClausesPercent;
        }

        /**
         * Format the constraint according to
         * <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-minimum-should-match.html">
         * the format specified in the Elasticsearch documentation
         * </a>.
         *
         * @param builder The builder to append the formatted value to.
         * @param ignoreConstraintCeiling The ceiling above which this constraint is no longer ignored.
         */
        void appendTo(StringBuilder builder, Integer ignoreConstraintCeiling) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
