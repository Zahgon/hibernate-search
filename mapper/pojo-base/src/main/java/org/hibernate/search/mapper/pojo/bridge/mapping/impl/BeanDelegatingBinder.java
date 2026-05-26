/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.mapping.impl;

import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.MarkerBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.RoutingBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.TypeBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.ValueBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.MarkerBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.PropertyBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.RoutingBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.TypeBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.ValueBinder;

/**
 * A binder that upon building retrieves a delegate binder from the bean provider,
 * then delegates to that binder.
 */
public final class BeanDelegatingBinder implements TypeBinder, PropertyBinder, RoutingBinder, MarkerBinder, IdentifierBinder, ValueBinder {

    private final BeanReference<?> delegateReference;

    public BeanDelegatingBinder(BeanReference<?> delegateReference) {
        this.delegateReference = delegateReference;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(TypeBindingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(PropertyBindingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(RoutingBindingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(MarkerBindingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(IdentifierBindingContext<?> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(ValueBindingContext<?> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <B> BeanHolder<? extends B> createDelegate(BeanResolver beanResolver, Class<B> expectedType) {
        return delegateReference.asSubTypeOf(expectedType).resolve(beanResolver);
    }
}
