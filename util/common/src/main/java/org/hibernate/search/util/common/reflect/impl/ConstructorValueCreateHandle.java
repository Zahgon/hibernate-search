/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reflect.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.hibernate.search.util.common.impl.Throwables;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;
import org.hibernate.search.util.common.reflect.spi.ValueCreateHandle;

public final class ConstructorValueCreateHandle<T> implements ValueCreateHandle<T> {

    private final Constructor<T> constructor;

    public ConstructorValueCreateHandle(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T create(Object... arguments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
