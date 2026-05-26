/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import java.util.Collection;
import java.util.Collections;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.AbstractPojoIndexingDependencyCollectorDirectValueNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;
import org.hibernate.search.mapper.pojo.model.PojoModelProperty;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;

/**
 * @param <P> The type of the property used as a root element.
 */
public class PojoModelPropertyRootElement<P> extends AbstractPojoModelCompositeElement<P> implements PojoModelProperty {

    private final BoundPojoModelPathValueNode<?, P, P> modelPath;

    public PojoModelPropertyRootElement(BoundPojoModelPathPropertyNode<?, P> modelPath, PojoBootstrapIntrospector introspector, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider) {
        super(introspector, typeAdditionalMetadataProvider);
        this.modelPath = modelPath.valueWithoutExtractors();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> Collection<M> markers(Class<M> markerType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeDependencies(PojoIndexingDependencyCollectorPropertyNode<?, P> dependencyCollector) {
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
}
