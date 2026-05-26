/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateSearchContextProviderService;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * Integrates Hibernate Search into Hibernate Core by registering its needed listeners
 *
 * @author Emmanuel Bernard
 * @author Hardy Ferentschik
 * @author Steve Ebersole
 */
public class HibernateSearchIntegrator implements Integrator {

    @Override
    public void integrate(Metadata metadata, BootstrapContext bootstrapContext, SessionFactoryImplementor sessionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
