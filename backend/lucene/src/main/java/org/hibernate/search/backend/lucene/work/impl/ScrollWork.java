/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.apache.lucene.search.IndexSearcher;

public class ScrollWork<ER> implements ReadWork<ER> {

    private final LuceneSearcher<?, ER> searcher;

    private final int offset;

    private final int limit;

    private final int totalHitCountThreshold;

    ScrollWork(LuceneSearcher<?, ER> searcher, int offset, int limit, int totalHitCountThreshold) {
        this.offset = offset;
        this.limit = limit;
        this.searcher = searcher;
        this.totalHitCountThreshold = totalHitCountThreshold;
    }

    @Override
    public ER execute(ReadWorkExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
