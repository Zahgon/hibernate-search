/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reflect.spi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.hibernate.search.util.common.reflect.impl.ConstructorValueCreateHandle;
import org.hibernate.search.util.common.reflect.impl.FieldValueReadHandle;
import org.hibernate.search.util.common.reflect.impl.MethodValueReadHandle;

@SuppressWarnings("deprecation")
final class MemberValueHandleFactory implements ValueHandleFactory, ValueReadHandleFactory {

    @Override
    public <T> ValueCreateHandle<T> createForConstructor(Constructor<T> constructor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueReadHandle<?> createForField(Field field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueReadHandle<?> createForMethod(Method method) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
