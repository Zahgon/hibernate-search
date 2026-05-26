/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

final class SimplePojoRuntimeIntrospector implements PojoRuntimeIntrospector {

    private static final SimplePojoRuntimeIntrospector INSTANCE = new SimplePojoRuntimeIntrospector();

    public static SimplePojoRuntimeIntrospector get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SimplePojoRuntimeIntrospector() {
    }

    @Override
    // The class of an object of type T is always a Class<? extends T>
    @SuppressWarnings("unchecked")
    public <T> PojoRawTypeIdentifier<? extends T> detectEntityType(T entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isIgnorableDataAccessThrowable(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object unproxy(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
