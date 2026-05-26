/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.models.spi.ClassDetailsRegistry;
import org.hibernate.resource.beans.container.spi.BeanContainer;
import org.hibernate.resource.beans.spi.ManagedBeanRegistry;
import org.hibernate.search.engine.Version;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.AllAwareConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.ConfigurationPropertyChecker;
import org.hibernate.search.engine.cfg.spi.ConfigurationProvider;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.common.spi.SearchIntegrationEnvironment;
import org.hibernate.search.engine.common.spi.SearchIntegrationPartialBuildState;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.bean.spi.BeanProvider;
import org.hibernate.search.mapper.orm.bootstrap.spi.HibernateOrmIntegrationBooterBehavior;
import org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings;
import org.hibernate.search.mapper.orm.cfg.spi.HibernateOrmMapperSpiSettings;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.coordination.impl.CoordinationConfigurationContextImpl;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.logging.impl.VersionLog;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateOrmMappingInitiator;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateOrmMappingKey;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reflect.spi.ValueHandleFactory;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceContributor;
import org.hibernate.service.spi.ServiceRegistryImplementor;

/**
 * A service that can perform the earliest steps of the integration of Hibernate Search into Hibernate ORM,
 * before {@link HibernateSearchIntegrator} is even called.
 * <p>
 * This is useful in particular when we need to plug in other services into Hibernate ORM,
 * and those services rely on the Hibernate Search configuration.
 */
public abstract class HibernateSearchPreIntegrationService implements Service, AutoCloseable {

    private static final ConfigurationProperty<Boolean> ENABLED = ConfigurationProperty.forKey(HibernateOrmMapperSettings.ENABLED).asBoolean().withDefault(HibernateOrmMapperSettings.Defaults.ENABLED).build();

    private static final ConfigurationProperty<Boolean> LOG_VERSION = ConfigurationProperty.forKey(HibernateOrmMapperSpiSettings.JBOSS_LOG_VERSION).asBoolean().withDefault(HibernateOrmMapperSpiSettings.Defaults.JBOSS_LOG_VERSIONS).build();

    public static class Contributor implements ServiceContributor {

        @Override
        public void contribute(StandardServiceRegistryBuilder serviceRegistryBuilder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Initiator implements StandardServiceInitiator<HibernateSearchPreIntegrationService> {

        private boolean initiated = false;

        @Override
        public Class<HibernateSearchPreIntegrationService> getServiceInitiated() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HibernateSearchPreIntegrationService initiateService(Map<String, Object> configurationValues, ServiceRegistryImplementor registry) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static SearchIntegrationEnvironment createEnvironment(ConfigurationPropertyChecker propertyChecker, ConfigurationPropertySource propertySource, ServiceRegistryImplementor registry) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private final ConfigurationPropertyChecker propertyChecker;

    private final ConfigurationPropertySource rawPropertySource;

    private CoordinationConfigurationContextImpl coordinationStrategyConfiguration;

    protected HibernateSearchPreIntegrationService(ConfigurationPropertyChecker propertyChecker, ConfigurationPropertySource rawPropertySource) {
        this.propertyChecker = propertyChecker;
        this.rawPropertySource = rawPropertySource;
    }

    @Override
    public final void close() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void doClose(Closer<RuntimeException> closer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The raw property source, without a mask or defaults from {@link ConfigurationProvider} applied.
     * Raw property sources are expected as input to engine SPIs such as
     * {@link SearchIntegrationEnvironment#builder(ConfigurationPropertySource, ConfigurationPropertyChecker)}
     * or {@link SearchIntegrationPartialBuildState#finalizer(ConfigurationPropertySource, ConfigurationPropertyChecker)}.
     * @see SearchIntegrationEnvironment#rootPropertySource(ConfigurationPropertySource, BeanResolver)
     */
    ConfigurationPropertySource rawPropertySource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A property source with the proper mask and defaults from {@link ConfigurationProvider} applied.
     * @see SearchIntegrationEnvironment#rootPropertySource(ConfigurationPropertySource, BeanResolver)
     */
    abstract ConfigurationPropertySource propertySource();

    public CoordinationConfigurationContextImpl coordinationStrategyConfiguration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ConfigurationPropertyChecker propertyChecker() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract BeanResolver beanResolver();

    abstract HibernateOrmIntegrationPartialBuildState doBootFirstPhase(Metadata metadata, ClassDetailsRegistry classDetailsRegistry, ValueHandleFactory valueHandleFactory);

    static class NotBooted extends HibernateSearchPreIntegrationService {

        private final SearchIntegrationEnvironment environment;

        private final ServiceRegistry serviceRegistry;

        NotBooted(ConfigurationPropertyChecker propertyChecker, ConfigurationPropertySource rawPropertySource, SearchIntegrationEnvironment environment, ServiceRegistry serviceRegistry) {
            super(propertyChecker, rawPropertySource);
            this.environment = environment;
            this.serviceRegistry = serviceRegistry;
        }

        @Override
        protected void doClose(Closer<RuntimeException> closer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        ConfigurationPropertySource propertySource() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        BeanResolver beanResolver() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        HibernateOrmIntegrationPartialBuildState doBootFirstPhase(Metadata metadata, ClassDetailsRegistry classDetailsRegistry, ValueHandleFactory valueHandleFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class PreBooted extends HibernateSearchPreIntegrationService {

        private final ConfigurationPropertySource propertySource;

        private final HibernateOrmIntegrationPartialBuildState partialBuildState;

        PreBooted(ConfigurationPropertyChecker propertyChecker, ConfigurationPropertySource rawPropertySource, HibernateOrmIntegrationPartialBuildState partialBuildState) {
            super(propertyChecker, rawPropertySource);
            this.propertySource = SearchIntegrationEnvironment.rootPropertySource(rawPropertySource, partialBuildState.beanResolver());
            this.partialBuildState = partialBuildState;
        }

        @Override
        protected void doClose(Closer<RuntimeException> closer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        ConfigurationPropertySource propertySource() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        BeanResolver beanResolver() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        HibernateOrmIntegrationPartialBuildState doBootFirstPhase(Metadata metadata, ClassDetailsRegistry classDetailsRegistry, ValueHandleFactory valueHandleFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
