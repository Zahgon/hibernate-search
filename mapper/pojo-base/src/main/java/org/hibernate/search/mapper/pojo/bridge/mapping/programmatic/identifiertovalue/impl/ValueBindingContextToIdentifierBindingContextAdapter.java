/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.identifiertovalue.impl;

import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.ValueBindingContext;
import org.hibernate.search.mapper.pojo.model.PojoModelValue;

final class ValueBindingContextToIdentifierBindingContextAdapter<I> implements IdentifierBindingContext<I> {

    private final ValueBindingContext<I> delegate;

    public ValueBindingContextToIdentifierBindingContextAdapter(ValueBindingContext<I> delegate) {
        this.delegate = delegate;
    }

    @Override
    public <I2> void bridge(Class<I2> expectedIdentifierType, IdentifierBridge<I2> bridge) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I2> void bridge(Class<I2> expectedIdentifierType, BeanHolder<? extends IdentifierBridge<I2>> bridgeHolder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelValue<I> bridgedElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NamedValues params() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
