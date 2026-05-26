/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.mapping.impl;

import java.util.function.Supplier;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.service.Service;

/**
 * A Hibernate ORM service providing context to Hibernate Search components
 * when all they have access to is a Hibernate ORM session factory or session.
 */
public final class HibernateSearchContextProviderService implements Service, AutoCloseable, Supplier<HibernateOrmMapping> {

    public static HibernateSearchContextProviderService get(SessionFactoryImplementor sessionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private volatile HibernateOrmMapping mapping;

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void initialize(HibernateOrmMapping mapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmMapping get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
