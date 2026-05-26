/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import org.hibernate.search.util.common.impl.SuppressingCloser;

final class CastingBeanReference<T> implements BeanReference<T> {

    private final BeanReference<?> casted;

    private final Class<T> expectedType;

    CastingBeanReference(BeanReference<?> casted, Class<T> expectedType) {
        this.casted = casted;
        this.expectedType = expectedType;
    }

    @Override
    // Checked using reflection
    @SuppressWarnings("unchecked")
    public BeanHolder<T> resolve(BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // Checked using reflection
    @SuppressWarnings("unchecked")
    public <U> BeanReference<? extends U> asSubTypeOf(Class<U> expectedType2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
