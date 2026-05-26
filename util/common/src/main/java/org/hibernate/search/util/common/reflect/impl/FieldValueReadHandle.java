/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reflect.impl;

import java.lang.reflect.Field;
import org.hibernate.search.util.common.impl.Throwables;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

public final class FieldValueReadHandle<T> implements ValueReadHandle<T> {

    private final Field field;

    public FieldValueReadHandle(Field field) {
        this.field = field;
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
