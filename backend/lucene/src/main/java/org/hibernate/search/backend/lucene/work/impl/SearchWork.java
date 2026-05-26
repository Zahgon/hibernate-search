/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.apache.lucene.search.IndexSearcher;

public class SearchWork<R> implements ReadWork<R> {

    private final LuceneSearcher<R, ?> searcher;

    private final int offset;

    private final Integer limit;

    private final int totalHitCountThreshold;

    SearchWork(LuceneSearcher<R, ?> searcher, Integer offset, Integer limit, int totalHitCountThreshold) {
        this.offset = offset == null ? 0 : offset;
        this.limit = limit;
        this.searcher = searcher;
        this.totalHitCountThreshold = totalHitCountThreshold;
    }

    @Override
    public R execute(ReadWorkExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
