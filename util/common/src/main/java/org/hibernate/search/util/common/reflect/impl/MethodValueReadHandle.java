/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reflect.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.hibernate.search.util.common.impl.Throwables;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

public final class MethodValueReadHandle<T> implements ValueReadHandle<T> {

    private final Method method;

    public MethodValueReadHandle(Method method) {
        this.method = method;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(Object thiz) {
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
}
