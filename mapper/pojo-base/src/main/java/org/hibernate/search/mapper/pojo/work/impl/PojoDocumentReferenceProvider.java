/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import org.hibernate.search.engine.backend.work.execution.spi.DocumentReferenceProvider;

public final class PojoDocumentReferenceProvider implements DocumentReferenceProvider {

    private final String documentIdentifier;

    private final String routingKey;

    private final Object entityIdentifier;

    public PojoDocumentReferenceProvider(String documentIdentifier, String routingKey, Object entityIdentifier) {
        this.documentIdentifier = documentIdentifier;
        this.routingKey = routingKey;
        this.entityIdentifier = entityIdentifier;
    }

    @Override
    public String identifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String routingKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object entityIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
