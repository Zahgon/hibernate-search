/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.function.Function;
import org.hibernate.search.engine.cfg.spi.ConvertUtils;
import org.hibernate.search.engine.cfg.spi.KeyContext;
import org.hibernate.search.engine.cfg.spi.OptionalPropertyContext;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.util.common.impl.Contracts;

public class KeyContextImpl implements KeyContext {

    private final String key;

    public KeyContextImpl(String key) {
        this.key = key;
    }

    @Override
    public OptionalPropertyContext<String> asString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<Boolean> asBoolean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<Integer> asIntegerPositiveOrZeroOrNegative() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<Integer> asIntegerPositiveOrZero() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<Integer> asIntegerStrictlyPositive() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<Long> asLongPositiveOrZeroOrNegative() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalPropertyContext<Long> asLongStrictlyPositive() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> OptionalPropertyContext<BeanReference<? extends T>> asBeanReference(Class<T> expectedBeanType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> OptionalPropertyContext<T> as(Class<T> expectedType, Function<String, T> parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
