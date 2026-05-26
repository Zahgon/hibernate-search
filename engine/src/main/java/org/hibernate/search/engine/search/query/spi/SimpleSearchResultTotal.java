/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.query.spi;

import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.query.SearchResultTotal;

public class SimpleSearchResultTotal implements SearchResultTotal {

    public static SimpleSearchResultTotal of(long totalHitCount, boolean isExact) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SimpleSearchResultTotal exact(long totalHitCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SimpleSearchResultTotal lowerBound(long totalHitCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final long totalHitCount;

    private final boolean isExact;

    private SimpleSearchResultTotal(long totalHitCount, boolean isExact) {
        this.totalHitCount = totalHitCount;
        this.isExact = isExact;
    }

    @Override
    public boolean isHitCountExact() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isHitCountLowerBound() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long hitCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long hitCountLowerBound() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
