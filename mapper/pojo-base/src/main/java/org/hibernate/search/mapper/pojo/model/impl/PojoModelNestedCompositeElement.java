/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import java.util.Collection;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.AbstractPojoIndexingDependencyCollectorDirectValueNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;
import org.hibernate.search.mapper.pojo.model.PojoModelProperty;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoPropertyAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

/**
 * @param <T> The type holding the property.
 * @param <P> The type of the property.
 */
class PojoModelNestedCompositeElement<T, P> extends AbstractPojoModelCompositeElement<P> implements PojoModelProperty {

    private final AbstractPojoModelCompositeElement<T> parent;

    private final BoundPojoModelPathValueNode<T, P, P> modelPath;

    private final PojoPropertyAdditionalMetadata propertyAdditionalMetadata;

    PojoModelNestedCompositeElement(AbstractPojoModelCompositeElement<T> parent, BoundPojoModelPathPropertyNode<T, P> modelPath, PojoPropertyAdditionalMetadata propertyAdditionalMetadata) {
        super(parent);
        this.parent = parent;
        this.modelPath = modelPath.valueWithoutExtractors();
        this.propertyAdditionalMetadata = propertyAdditionalMetadata;
    }

    @Override
    public <M> Collection<M> markers(Class<M> markerType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeDependencies(PojoIndexingDependencyCollectorTypeNode<T> dependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    PojoElementAccessor<P> doCreateAccessor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    BoundPojoModelPathTypeNode<P> getModelPathTypeNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ValueReadHandle<P> getHandle() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
