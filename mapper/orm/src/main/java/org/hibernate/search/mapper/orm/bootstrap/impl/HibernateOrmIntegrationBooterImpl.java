/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.models.spi.ClassDetailsRegistry;
import org.hibernate.resource.beans.container.spi.ExtendedBeanManager;
import org.hibernate.search.mapper.orm.bootstrap.spi.HibernateOrmIntegrationBooter;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateSearchContextProviderService;
import org.hibernate.search.mapper.orm.spi.EnvironmentSynchronizer;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Futures;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reflect.spi.ValueHandleFactory;
import org.hibernate.service.ServiceRegistry;

public class HibernateOrmIntegrationBooterImpl implements HibernateOrmIntegrationBooter {

    private final Metadata metadata;

    private final ValueHandleFactory valueHandleFactory;

    private final HibernateSearchPreIntegrationService preIntegrationService;

    private final Optional<EnvironmentSynchronizer> environmentSynchronizer;

    private final ClassDetailsRegistry classDetailsRegistry;

    // There is no alternative to getReflectionManager() at the moment.
    @SuppressWarnings("deprecation")
    private HibernateOrmIntegrationBooterImpl(BuilderImpl builder) {
        this.metadata = builder.metadata;
        ServiceRegistry serviceRegistry = builder.bootstrapContext.getServiceRegistry();
        this.valueHandleFactory = builder.valueHandleFactory != null ? builder.valueHandleFactory : ValueHandleFactory.usingMethodHandle(MethodHandles.publicLookup());
        this.preIntegrationService = HibernateOrmUtils.getServiceOrFail(serviceRegistry, HibernateSearchPreIntegrationService.class);
        Optional<EnvironmentSynchronizer> providedEnvironmentSynchronizer = HibernateOrmUtils.getServiceOrEmpty(serviceRegistry, EnvironmentSynchronizer.class);
        if (providedEnvironmentSynchronizer.isPresent()) {
            // Allow integrators to override the environment synchronizer with an ORM Service
            this.environmentSynchronizer = providedEnvironmentSynchronizer;
        } else {
            ConfigurationService ormConfigurationService = HibernateOrmUtils.getServiceOrFail(serviceRegistry, ConfigurationService.class);
            Object unknownBeanManager = ormConfigurationService.getSettings().get(AvailableSettings.CDI_BEAN_MANAGER);
            if (unknownBeanManager == null) {
                // Try jakarta settings as a default
                // Not getting the constant from AvailableSettings because it does not exist in some ORM versions
                unknownBeanManager = ormConfigurationService.getSettings().get("jakarta.persistence.bean.manager");
            }
            if (unknownBeanManager instanceof ExtendedBeanManager) {
                ExtendedBeanManager extendedBeanManager = (ExtendedBeanManager) unknownBeanManager;
                ExtendedBeanManagerSynchronizer synchronizer = new ExtendedBeanManagerSynchronizer();
                extendedBeanManager.registerLifecycleListener(synchronizer);
                this.environmentSynchronizer = Optional.of(synchronizer);
            } else {
                this.environmentSynchronizer = Optional.empty();
            }
        }
        this.classDetailsRegistry = builder.bootstrapContext.getModelsContext().getClassDetailsRegistry();
    }

    @Override
    public void preBoot(BiConsumer<String, Object> propertyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<HibernateSearchContextProviderService> orchestrateBootAndShutdown(CompletionStage<SessionFactoryImplementor> sessionFactoryReadyStage, CompletionStage<?> sessionFactoryDestroyingStage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private HibernateSearchContextProviderService bootNow(SessionFactoryImplementor sessionFactoryImplementor) {
        HibernateOrmIntegrationPartialBuildState partialBuildState = preIntegrationService.doBootFirstPhase(metadata, classDetailsRegistry, valueHandleFactory);
        try {
            return partialBuildState.doBootSecondPhase(sessionFactoryImplementor, preIntegrationService.rawPropertySource(), preIntegrationService.propertyChecker());
        } catch (RuntimeException e) {
            new SuppressingCloser(e).push(HibernateOrmIntegrationPartialBuildState::closeOnFailure, partialBuildState);
            throw e;
        }
    }

    public static class BuilderImpl implements Builder {

        private final Metadata metadata;

        private final BootstrapContext bootstrapContext;

        private ValueHandleFactory valueHandleFactory;

        public BuilderImpl(Metadata metadata, BootstrapContext bootstrapContext) {
            this.metadata = metadata;
            this.bootstrapContext = bootstrapContext;
        }

        @Override
        public Builder valueReadHandleFactory(ValueHandleFactory valueHandleFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HibernateOrmIntegrationBooterImpl build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
