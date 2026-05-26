/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.building.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexBindingContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexFieldTypeDefaultsProvider;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexedEntityBindingContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingBuildContext;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.TypeBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.ValueBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundIdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundPropertyBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundTypeBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundValueBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.DefaultIdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.PropertyBindingContextImpl;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.TypeBindingContextImpl;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.ValueBindingContextImpl;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributor;
import org.hibernate.search.mapper.pojo.bridge.mapping.impl.BridgeResolver;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.PropertyBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.TypeBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.ValueBinder;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;
import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorHolder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoEntityTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.dependency.impl.PojoPropertyIndexingDependencyConfigurationContextImpl;
import org.hibernate.search.mapper.pojo.model.dependency.impl.PojoTypeIndexingDependencyConfigurationContextImpl;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelPropertyRootElement;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelTypeRootElement;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * Binds a mapping to a given entity model and index model
 * by creating the appropriate {@link ContainerExtractor extractors} and bridges.
 * <p>
 * Also binds the bridges where appropriate:
 * {@link TypeBinder#bind(TypeBindingContext)},
 * {@link PropertyBinder#bind(PropertyBindingContext)},
 * {@link ValueBinder#bind(ValueBindingContext)}.
 * <p>
 * Incidentally, this will also generate the index model,
 * due to bridges contributing to the index model as we bind them.
 */
public final class PojoIndexModelBinder {

    private final BeanResolver beanResolver;

    private final PojoBootstrapIntrospector introspector;

    private final ContainerExtractorBinder extractorBinder;

    private final BridgeResolver bridgeResolver;

    private final PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider;

    PojoIndexModelBinder(MappingBuildContext buildContext, PojoBootstrapIntrospector introspector, ContainerExtractorBinder extractorBinder, BridgeResolver bridgeResolver, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider) {
        this.beanResolver = buildContext.beanResolver();
        this.introspector = introspector;
        this.extractorBinder = extractorBinder;
        this.bridgeResolver = bridgeResolver;
        this.typeAdditionalMetadataProvider = typeAdditionalMetadataProvider;
    }

    public <T> Optional<BoundPojoModelPathPropertyNode<T, ?>> createEntityIdPropertyPath(PojoTypeModel<T> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <C> BoundContainerExtractorPath<C, ?> bindExtractorPath(PojoTypeModel<C> pojoGenericTypeModel, ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <C, V> ContainerExtractorHolder<C, V> createExtractors(BoundContainerExtractorPath<C, V> boundExtractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <I> BoundIdentifierBridge<I> bindIdentifier(Optional<IndexedEntityBindingContext> indexedEntityBindingContext, BoundPojoModelPathPropertyNode<?, I> modelPath, IdentifierBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <I> BoundIdentifierBridge<I> bindIdentifier(Optional<IndexedEntityBindingContext> indexedEntityBindingContext, PojoTypeModel<I> identifierTypeModel, IdentifierBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Optional<BoundTypeBridge<T>> bindType(IndexBindingContext indexBindingContext, BoundPojoModelPathTypeNode<T> modelPath, TypeBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <P> Optional<BoundPropertyBridge<P>> bindProperty(IndexBindingContext indexBindingContext, BoundPojoModelPathPropertyNode<?, P> modelPath, PropertyBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <V> Optional<BoundValueBridge<V, ?>> bindValue(IndexBindingContext indexBindingContext, BoundPojoModelPathValueNode<?, ?, V> modelPath, boolean multiValued, ValueBinder binder, Map<String, Object> params, String relativeFieldName, FieldModelContributor contributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
