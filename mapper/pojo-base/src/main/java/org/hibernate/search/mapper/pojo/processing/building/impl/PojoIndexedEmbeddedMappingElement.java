/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.building.impl;

import java.util.Objects;
import org.hibernate.search.engine.mapper.model.spi.MappingElement;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.util.common.reporting.EventContext;

public class PojoIndexedEmbeddedMappingElement implements MappingElement {

    private final PojoRawTypeIdentifier<?> declaringType;

    private final String declaringPropertyName;

    // Having multiple @IndexedEmbeddeds on the same property with the same prefix is forbidden,
    // so this will allow us to distinguish between the @IndexedEmbeddeds on the same property.
    private final String relativePrefix;

    public PojoIndexedEmbeddedMappingElement(PojoRawTypeIdentifier<?> declaringType, String declaringPropertyName, String relativePrefix) {
        this.declaringType = declaringType;
        this.declaringPropertyName = declaringPropertyName;
        this.relativePrefix = relativePrefix;
    }

    @Override
    public String toString() {
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
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
