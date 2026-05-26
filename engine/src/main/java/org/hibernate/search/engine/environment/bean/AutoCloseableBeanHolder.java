/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * A bean holder that calls {@link AutoCloseable#close()} on its instance upon being {@link #close() closed}.
 * @param <T>
 */
final class AutoCloseableBeanHolder<T extends AutoCloseable> implements BeanHolder<T> {

    private final T instance;

    AutoCloseableBeanHolder(T instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
