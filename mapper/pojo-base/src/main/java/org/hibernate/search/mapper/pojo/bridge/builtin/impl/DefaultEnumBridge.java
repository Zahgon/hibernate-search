/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import org.hibernate.search.engine.cfg.spi.ParseUtils;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.ValueBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.ValueBinder;

public final class DefaultEnumBridge<T extends Enum<T>> extends AbstractStringBasedDefaultBridge<T> {

    private final Class<T> enumType;

    public DefaultEnumBridge(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(IdentifierBridge<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ValueBridge<?, ?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isCompatibleWith(Object other) {
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        DefaultEnumBridge<?> castedOther = (DefaultEnumBridge<?>) other;
        return enumType.equals(castedOther.enumType);
    }

    @Override
    protected String toString(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected T fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Binder implements IdentifierBinder, ValueBinder {

        public static final Binder INSTANCE = new Binder();

        private Binder() {
        }

        @Override
        // The bridge resolver performs the checks using reflection
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public void bind(IdentifierBindingContext<?> context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private <V extends Enum<V>> void doBind(IdentifierBindingContext<?> context, Class<V> enumType) {
            context.bridge(enumType, new DefaultEnumBridge<>(enumType));
        }

        @Override
        // The bridge resolver performs the checks using reflection
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public void bind(ValueBindingContext<?> context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private <V extends Enum<V>> void doBind(ValueBindingContext<?> context, Class<V> enumType) {
            context.bridge(enumType, new DefaultEnumBridge<>(enumType));
        }
    }
}
