/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.binding.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaElement;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexBindingContext;
import org.hibernate.search.mapper.pojo.bridge.TypeBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.TypeBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.TypeBinder;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.PojoModelType;
import org.hibernate.search.mapper.pojo.model.dependency.PojoTypeIndexingDependencyConfigurationContext;
import org.hibernate.search.mapper.pojo.model.dependency.impl.PojoTypeIndexingDependencyConfigurationContextImpl;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelTypeRootElement;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.impl.AbstractCloser;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class TypeBindingContextImpl<T> extends AbstractCompositeBindingContext implements TypeBindingContext {

    private final PojoBootstrapIntrospector introspector;

    private final PojoTypeModel<T> typeModel;

    private final PojoModelTypeRootElement<T> bridgedElement;

    private final PojoTypeIndexingDependencyConfigurationContextImpl<T> dependencyContext;

    private final IndexFieldTypeFactory indexFieldTypeFactory;

    private final PojoTreeContributionListener listener;

    private final IndexSchemaElement indexSchemaElement;

    private PartialBinding<T> partialBinding;

    public TypeBindingContextImpl(BeanResolver beanResolver, PojoBootstrapIntrospector introspector, PojoTypeModel<T> typeModel, IndexBindingContext indexBindingContext, PojoModelTypeRootElement<T> bridgedElement, PojoTypeIndexingDependencyConfigurationContextImpl<T> dependencyContext, Map<String, Object> params) {
        super(beanResolver, params);
        this.introspector = introspector;
        this.typeModel = typeModel;
        this.bridgedElement = bridgedElement;
        this.dependencyContext = dependencyContext;
        this.indexFieldTypeFactory = indexBindingContext.createTypeFactory();
        this.listener = new PojoTreeContributionListener();
        this.indexSchemaElement = indexBindingContext.schemaElement(listener);
    }

    @Override
    public <T2> void bridge(Class<T2> expectedEntityType, TypeBridge<T2> bridge) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T2> void bridge(Class<T2> expectedEntityType, BeanHolder<? extends TypeBridge<T2>> bridgeHolder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelType bridgedElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeIndexingDependencyConfigurationContext dependencies() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexFieldTypeFactory typeFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaElement indexSchemaElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<BoundTypeBridge<T>> applyBinder(TypeBinder binder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For the eclipse-compiler: complains on bridge not bing closed
    @SuppressWarnings("resource")
    private <T2> void checkAndBind(BeanHolder<? extends TypeBridge<T2>> bridgeHolder, PojoRawTypeModel<?> expectedPropertyTypeModel) {
        if (!typeModel.rawType().isSubTypeOf(expectedPropertyTypeModel)) {
            throw MappingLog.INSTANCE.invalidInputTypeForBridge(bridgeHolder.get(), typeModel, expectedPropertyTypeModel);
        }
        // We check that T extends T2 explicitly using reflection (see above)
        @SuppressWarnings("unchecked")
        BeanHolder<? extends TypeBridge<? super T>> castedBridgeHolder = (BeanHolder<? extends TypeBridge<? super T>>) bridgeHolder;
        this.partialBinding = new PartialBinding<>(castedBridgeHolder);
    }

    private static class PartialBinding<T> {

        private final BeanHolder<? extends TypeBridge<? super T>> bridgeHolder;

        private PartialBinding(BeanHolder<? extends TypeBridge<? super T>> bridgeHolder) {
            this.bridgeHolder = bridgeHolder;
        }

        void abort(AbstractCloser<?, ?> closer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        BoundTypeBridge<T> complete(PojoModelTypeRootElement<T> bridgedElement, PojoTypeIndexingDependencyConfigurationContextImpl<T> dependencyContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
