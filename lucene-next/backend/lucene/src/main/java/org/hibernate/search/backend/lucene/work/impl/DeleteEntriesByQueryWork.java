/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterDelegator;
import org.apache.lucene.search.Query;

public class DeleteEntriesByQueryWork implements IndexManagementWork<Long> {

    private final Query query;

    DeleteEntriesByQueryWork(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long execute(IndexManagementWorkExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getInfo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
