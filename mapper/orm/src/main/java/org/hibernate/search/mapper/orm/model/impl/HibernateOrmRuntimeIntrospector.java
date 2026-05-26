/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import org.hibernate.AssertionFailure;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoRawTypeIdentifierResolver;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;

/**
 * @author Sanne Grinovero (C) 2011 Red Hat Inc.
 */
public class HibernateOrmRuntimeIntrospector implements PojoRuntimeIntrospector {

    private final PojoRawTypeIdentifierResolver typeIdentifierResolver;

    private final SharedSessionContractImplementor sessionImplementor;

    public HibernateOrmRuntimeIntrospector(PojoRawTypeIdentifierResolver typeIdentifierResolver, SharedSessionContractImplementor sessionImplementor) {
        this.typeIdentifierResolver = typeIdentifierResolver;
        this.sessionImplementor = sessionImplementor;
    }

    @Override
    // As long as T is the declared type of an entity or one of its supertypes, this cast is safe
    @SuppressWarnings("unchecked")
    public <T> PojoRawTypeIdentifier<? extends T> detectEntityType(T entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object unproxy(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isIgnorableDataAccessThrowable(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
