/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;

/**
 * @param <T> The type of the root element.
 */
class PojoRootElementAccessor<T> implements PojoElementAccessor<T> {

    PojoRootElementAccessor() {
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // By construction, this accessor will only be passed PojoElement returning type T
    @SuppressWarnings("unchecked")
    public T read(Object parentElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
