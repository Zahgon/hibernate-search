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
import org.hibernate.search.mapper.pojo.bridge.PropertyBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.PropertyBinder;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.PojoModelProperty;
import org.hibernate.search.mapper.pojo.model.dependency.PojoPropertyIndexingDependencyConfigurationContext;
import org.hibernate.search.mapper.pojo.model.dependency.impl.PojoPropertyIndexingDependencyConfigurationContextImpl;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelPropertyRootElement;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.impl.AbstractCloser;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class PropertyBindingContextImpl<P> extends AbstractCompositeBindingContext implements PropertyBindingContext {

    private final PojoBootstrapIntrospector introspector;

    private final PojoTypeModel<?> propertyTypeModel;

    private final PojoModelPropertyRootElement<P> bridgedElement;

    private final PojoPropertyIndexingDependencyConfigurationContextImpl<P> dependencyContext;

    private final IndexFieldTypeFactory indexFieldTypeFactory;

    private final PojoTreeContributionListener listener;

    private final IndexSchemaElement indexSchemaElement;

    private PartialBinding<P> partialBinding;

    public PropertyBindingContextImpl(BeanResolver beanResolver, PojoBootstrapIntrospector introspector, PojoTypeModel<P> propertyTypeModel, IndexBindingContext indexBindingContext, PojoModelPropertyRootElement<P> bridgedElement, PojoPropertyIndexingDependencyConfigurationContextImpl<P> dependencyContext, Map<String, Object> params) {
        super(beanResolver, params);
        this.introspector = introspector;
        this.propertyTypeModel = propertyTypeModel;
        this.bridgedElement = bridgedElement;
        this.dependencyContext = dependencyContext;
        this.indexFieldTypeFactory = indexBindingContext.createTypeFactory();
        this.listener = new PojoTreeContributionListener();
        this.indexSchemaElement = indexBindingContext.schemaElement(listener);
    }

    @Override
    public <P2> void bridge(Class<P2> expectedPropertyType, PropertyBridge<P2> bridge) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <P2> void bridge(Class<P2> expectedPropertyType, BeanHolder<? extends PropertyBridge<P2>> bridgeHolder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelProperty bridgedElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPropertyIndexingDependencyConfigurationContext dependencies() {
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

    public Optional<BoundPropertyBridge<P>> applyBinder(PropertyBinder binder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For the eclipse-compiler: complains on bridge not bing closed
    @SuppressWarnings("resource")
    private <P2> void checkAndBind(BeanHolder<? extends PropertyBridge<P2>> bridgeHolder, PojoRawTypeModel<?> expectedPropertyTypeModel) {
        if (!propertyTypeModel.rawType().isSubTypeOf(expectedPropertyTypeModel)) {
            throw MappingLog.INSTANCE.invalidInputTypeForBridge(bridgeHolder.get(), propertyTypeModel, expectedPropertyTypeModel);
        }
        // We check that P extends P2 explicitly using reflection (see above)
        @SuppressWarnings("unchecked")
        BeanHolder<? extends PropertyBridge<? super P>> castedBridgeHolder = (BeanHolder<? extends PropertyBridge<? super P>>) bridgeHolder;
        this.partialBinding = new PartialBinding<>(castedBridgeHolder);
    }

    private static class PartialBinding<P> {

        private final BeanHolder<? extends PropertyBridge<? super P>> bridgeHolder;

        private PartialBinding(BeanHolder<? extends PropertyBridge<? super P>> bridgeHolder) {
            this.bridgeHolder = bridgeHolder;
        }

        void abort(AbstractCloser<?, ?> closer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        BoundPropertyBridge<P> complete(PojoModelPropertyRootElement<P> bridgedElement, PojoPropertyIndexingDependencyConfigurationContextImpl<P> dependencyContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
