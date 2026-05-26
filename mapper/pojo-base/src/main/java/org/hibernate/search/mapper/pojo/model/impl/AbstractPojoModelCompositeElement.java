/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;
import org.hibernate.search.mapper.pojo.model.PojoModelCompositeElement;
import org.hibernate.search.mapper.pojo.model.PojoModelProperty;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoPropertyAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * @param <V> The type of the element, i.e. the type of values returned by accessors to this element.
 */
public abstract class AbstractPojoModelCompositeElement<V> implements PojoModelCompositeElement {

    private final PojoBootstrapIntrospector introspector;

    private final PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<String, PojoModelNestedCompositeElement<V, ?>> properties = new LinkedHashMap<>();

    private PojoTypeAdditionalMetadata typeAdditionalMetadata;

    private boolean propertiesInitialized = false;

    private PojoElementAccessor<?> accessor;

    AbstractPojoModelCompositeElement(AbstractPojoModelCompositeElement<?> parent) {
        this.introspector = parent.introspector;
        this.typeAdditionalMetadataProvider = parent.typeAdditionalMetadataProvider;
    }

    AbstractPojoModelCompositeElement(PojoBootstrapIntrospector introspector, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider) {
        this.introspector = introspector;
        this.typeAdditionalMetadataProvider = typeAdditionalMetadataProvider;
    }

    @Override
    // The cast is checked using reflection
    @SuppressWarnings("unchecked")
    public final <T> PojoElementAccessor<T> createAccessor(Class<T> requestedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoElementAccessor<?> createAccessor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isAssignableTo(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> rawType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelNestedCompositeElement<?, ?> property(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<? extends PojoModelProperty> properties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasNonRootDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PojoElementAccessor<V> doCreateAccessor();

    abstract BoundPojoModelPathTypeNode<V> getModelPathTypeNode();

    final boolean hasAccessor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final void contributePropertyDependencies(PojoIndexingDependencyCollectorTypeNode<V> dependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoTypeModel<V> getTypeModel() {
        return getModelPathTypeNode().getTypeModel();
    }

    private PojoTypeAdditionalMetadata getTypeAdditionalMetadata() {
        if (typeAdditionalMetadata == null) {
            typeAdditionalMetadata = typeAdditionalMetadataProvider.get(getModelPathTypeNode().getTypeModel().rawType());
        }
        return typeAdditionalMetadata;
    }
}
