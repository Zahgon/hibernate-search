/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.binding.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexedEntityBindingContext;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.PojoIdentifierBridgeDocumentValueConverter;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.PojoIdentifierBridgeParseConverter;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.PojoModelValue;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelValueElement;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.impl.AbstractCloser;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class DefaultIdentifierBindingContext<I> extends AbstractBindingContext implements IdentifierBindingContext<I> {

    private final PojoBootstrapIntrospector introspector;

    private final Optional<IndexedEntityBindingContext> indexedEntityBindingContext;

    private final PojoTypeModel<I> identifierTypeModel;

    private final PojoModelValue<I> bridgedElement;

    private PartialBinding<I> partialBinding;

    public DefaultIdentifierBindingContext(BeanResolver beanResolver, PojoBootstrapIntrospector introspector, Optional<IndexedEntityBindingContext> indexedEntityBindingContext, PojoTypeModel<I> valueTypeModel, Map<String, Object> params) {
        super(beanResolver, params);
        this.introspector = introspector;
        this.indexedEntityBindingContext = indexedEntityBindingContext;
        this.identifierTypeModel = valueTypeModel;
        this.bridgedElement = new PojoModelValueElement<>(introspector, valueTypeModel);
    }

    @Override
    public <I2> void bridge(Class<I2> expectedValueType, IdentifierBridge<I2> bridge) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // For the eclipse-compiler: complains on bridge not bing closed
    @SuppressWarnings("resource")
    public <I2> void bridge(Class<I2> expectedValueType, BeanHolder<? extends IdentifierBridge<I2>> bridgeHolder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void applyBridge(Class<I> expectedValueType, BeanHolder<? extends IdentifierBridge<I>> bridgeHolder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelValue<I> bridgedElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BoundIdentifierBridge<I> applyBinder(IdentifierBinder binder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void abortBridge(AbstractCloser<?, ?> closer, BeanHolder<? extends IdentifierBridge<?>> bridgeHolder) {
        closer.push(IdentifierBridge::close, bridgeHolder, BeanHolder::get);
        closer.push(BeanHolder::close, bridgeHolder);
    }

    private static class PartialBinding<I> {

        private final BeanHolder<? extends IdentifierBridge<I>> bridgeHolder;

        private final Class<I> expectedValueType;

        private PartialBinding(BeanHolder<? extends IdentifierBridge<I>> bridgeHolder, Class<I> expectedValueType) {
            this.bridgeHolder = bridgeHolder;
            this.expectedValueType = expectedValueType;
        }

        void abort(AbstractCloser<?, ?> closer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        BoundIdentifierBridge<I> complete(Optional<IndexedEntityBindingContext> indexedEntityBindingContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
