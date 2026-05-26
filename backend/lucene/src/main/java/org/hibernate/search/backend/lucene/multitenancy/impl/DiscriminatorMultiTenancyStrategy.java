/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.multitenancy.impl;

import java.util.Set;
import org.hibernate.search.backend.lucene.logging.impl.ConfigurationLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Query;

public class DiscriminatorMultiTenancyStrategy implements MultiTenancyStrategy {

    @Override
    public void contributeToIndexedDocument(Document document, String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query filterOrNull(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query filterOrNull(Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkTenantId(String tenantId, EventContext backendContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkTenantId(Set<String> tenantIds, EventContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
