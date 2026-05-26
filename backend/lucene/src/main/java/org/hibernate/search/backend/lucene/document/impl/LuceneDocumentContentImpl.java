/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.impl;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneDocumentContent;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;

public class LuceneDocumentContentImpl implements LuceneDocumentContent {

    private final Document document = new Document();

    private final Map<String, EncounteredFieldStatus> fieldStatus = new HashMap<>();

    @Override
    public void addField(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addFieldName(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void checkNoValueYetForSingleValued(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Document finalizeDocument(MultiTenancyStrategy multiTenancyStrategy, String tenantId, String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum EncounteredFieldStatus {

        ENCOUNTERED, ENCOUNTERED_AND_NAME_INDEXED
    }
}
