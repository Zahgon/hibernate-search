/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Member;
import org.hibernate.search.util.common.impl.Throwables;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

public final class MethodHandleValueReadHandle<T> implements ValueReadHandle<T> {

    private final Member member;

    private final MethodHandle getter;

    public MethodHandleValueReadHandle(Member member, MethodHandle getter) {
        this.member = member;
        this.getter = getter;
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
