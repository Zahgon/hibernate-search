/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.util.Objects;

final class OutboxEventReference {

    private final String entityName;

    private final String entityId;

    public OutboxEventReference(String entityName, String entityId) {
        this.entityName = entityName;
        this.entityId = entityId;
    }

    public String getEntityId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
