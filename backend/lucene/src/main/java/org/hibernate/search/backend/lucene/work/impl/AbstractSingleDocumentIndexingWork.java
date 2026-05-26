/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

public abstract class AbstractSingleDocumentIndexingWork extends AbstractIndexingWork<Long> implements SingleDocumentIndexingWork {

    protected final String tenantId;

    protected final String entityTypeName;

    protected final Object entityIdentifier;

    protected final String documentIdentifier;

    AbstractSingleDocumentIndexingWork(String workType, String tenantId, String entityTypeName, Object entityIdentifier, String documentIdentifier) {
        super(workType);
        this.tenantId = tenantId;
        this.entityTypeName = entityTypeName;
        this.entityIdentifier = entityIdentifier;
        this.documentIdentifier = documentIdentifier;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getEntityTypeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getEntityIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getQueuingKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
