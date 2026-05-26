/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.lang.invoke.MethodHandles;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.util.automaton.LevenshteinAutomata;

/**
 * @author Emmanuel Bernard
 */
class TermQueryContext {

    private static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    private final Approximation approximation;

    private int maxEditDistance = FuzzyQuery.defaultMaxEdits;

    private int prefixLength = 0;

    public TermQueryContext(Approximation approximation) {
        this.approximation = approximation;
    }

    public void setPrefixLength(int prefixLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Approximation getApproximation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getMaxEditDistance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxEditDistance(int maxEditDistance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getPrefixLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public enum Approximation {

        EXACT, WILDCARD, FUZZY
    }
}
