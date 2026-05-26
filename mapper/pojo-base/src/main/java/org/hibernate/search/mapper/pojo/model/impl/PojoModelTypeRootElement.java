/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;
import org.hibernate.search.mapper.pojo.model.PojoModelType;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;

/**
 * @param <T> The type used as a root element.
 */
public class PojoModelTypeRootElement<T> extends AbstractPojoModelCompositeElement<T> implements PojoModelType {

    private final BoundPojoModelPathTypeNode<T> modelPath;

    public PojoModelTypeRootElement(BoundPojoModelPathTypeNode<T> modelPath, PojoBootstrapIntrospector introspector, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider) {
        super(introspector, typeAdditionalMetadataProvider);
        this.modelPath = modelPath;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeDependencies(PojoIndexingDependencyCollectorTypeNode<T> dependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    PojoElementAccessor<T> doCreateAccessor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    BoundPojoModelPathTypeNode<T> getModelPathTypeNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
