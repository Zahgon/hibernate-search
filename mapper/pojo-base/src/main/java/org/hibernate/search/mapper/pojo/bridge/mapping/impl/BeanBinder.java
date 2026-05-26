/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.mapping.impl;

import java.lang.reflect.Type;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.ValueBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.ValueBinder;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reflect.impl.GenericTypeContext;

/**
 * A binder that simply retrieves the bridge as a bean from the bean provider.
 */
public final class BeanBinder implements IdentifierBinder, ValueBinder {

    private final BeanReference<?> beanReference;

    public BeanBinder(BeanReference<?> beanReference) {
        this.beanReference = beanReference;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void bind(IdentifierBindingContext<?> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void bind(ValueBindingContext<?> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Using reflection
    @SuppressWarnings("unchecked")
    private <B extends IdentifierBridge<I>, I> void doBind(BeanHolder<B> bridgeHolder, IdentifierBindingContext<?> context) {
        IdentifierBridge<I> bridge = bridgeHolder.get();
        GenericTypeContext bridgeTypeContext = new GenericTypeContext(bridge.getClass());
        Type typeArgument = bridgeTypeContext.resolveTypeArgument(IdentifierBridge.class, 0).orElseThrow(() -> new AssertionFailure("Could not auto-detect the input type for identifier bridge '" + bridge + "'."));
        if (typeArgument instanceof Class) {
            context.bridge((Class<I>) typeArgument, bridge);
        } else {
            throw MappingLog.INSTANCE.invalidGenericParameterToInferIdentifierType(bridge, typeArgument);
        }
    }

    // Using reflection
    @SuppressWarnings("unchecked")
    private <B extends ValueBridge<V, F>, V, F> void doBind(BeanHolder<B> bridgeHolder, ValueBindingContext<?> context) {
        ValueBridge<V, F> bridge = bridgeHolder.get();
        GenericTypeContext bridgeTypeContext = new GenericTypeContext(bridge.getClass());
        Type typeArgument = bridgeTypeContext.resolveTypeArgument(ValueBridge.class, 0).orElseThrow(() -> new AssertionFailure("Could not auto-detect the input type for value bridge '" + bridge + "'."));
        if (typeArgument instanceof Class) {
            context.bridge((Class<V>) typeArgument, bridge);
        } else {
            throw MappingLog.INSTANCE.invalidGenericParameterToInferValueType(bridge, typeArgument);
        }
    }

    private <T> BeanHolder<? extends T> doBuild(BeanResolver beanResolver, Class<T> expectedType) {
        return beanReference.asSubTypeOf(expectedType).resolve(beanResolver);
    }
}
