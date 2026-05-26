/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import org.hibernate.search.engine.cfg.spi.ConvertUtils;
import org.hibernate.search.engine.cfg.spi.DefaultedPropertyContext;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalPropertyContext;

final class OptionalPropertyContextImpl<T> implements OptionalPropertyContext<T> {

    private static final Pattern MULTI_VALUE_SEPARATOR_PATTERN = Pattern.compile(",");

    private final String key;

    private final Function<Object, T> converter;

    OptionalPropertyContextImpl(String key, Function<Object, T> converter) {
        this.key = key;
        this.converter = converter;
    }

    @Override
    public OptionalPropertyContext<T> substitute(UnaryOperator<Object> substitution) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<T> substitute(Object expected, Object replacement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<T> validate(Consumer<T> validation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<List<T>> multivalued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DefaultedPropertyContext<T> withDefault(T defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DefaultedPropertyContext<T> withDefault(Supplier<T> defaultValueSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalConfigurationProperty<T> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
