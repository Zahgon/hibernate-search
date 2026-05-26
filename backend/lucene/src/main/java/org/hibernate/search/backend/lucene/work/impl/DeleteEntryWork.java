/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterDelegator;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

public class DeleteEntryWork extends AbstractSingleDocumentIndexingWork {

    private final Query filter;

    DeleteEntryWork(String tenantId, String entityTypeName, Object entityIdentifier, String documentIdentifier, Query filter) {
        super("deleteEntry", tenantId, entityTypeName, entityIdentifier, documentIdentifier);
        this.filter = filter;
    }

    @Override
    public Long execute(IndexingWorkExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
