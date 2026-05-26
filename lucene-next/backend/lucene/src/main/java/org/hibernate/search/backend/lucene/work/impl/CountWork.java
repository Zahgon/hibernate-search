/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.apache.lucene.search.IndexSearcher;

public class CountWork implements ReadWork<Integer> {

    private final LuceneSearcher<?, ?> searcher;

    CountWork(LuceneSearcher<?, ?> searcher) {
        this.searcher = searcher;
    }

    @Override
    public Integer execute(ReadWorkExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
