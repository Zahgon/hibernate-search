/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import java.util.Optional;
import java.util.function.BiConsumer;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.ConfigurationPropertyChecker;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.common.spi.SearchIntegrationFinalizer;
import org.hibernate.search.engine.common.spi.SearchIntegrationPartialBuildState;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.orm.cfg.spi.HibernateOrmMapperSpiSettings;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateOrmMapping;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateOrmMappingKey;
import org.hibernate.search.mapper.orm.mapping.impl.HibernateSearchContextProviderService;
import org.hibernate.search.util.common.AssertionFailure;

final class HibernateOrmIntegrationPartialBuildState {

    private static final OptionalConfigurationProperty<HibernateOrmIntegrationPartialBuildState> INTEGRATION_PARTIAL_BUILD_STATE = ConfigurationProperty.forKey(HibernateOrmMapperSpiSettings.INTEGRATION_PARTIAL_BUILD_STATE).as(HibernateOrmIntegrationPartialBuildState.class, HibernateOrmIntegrationPartialBuildState::parse).build();

    public static Optional<HibernateOrmIntegrationPartialBuildState> get(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static HibernateOrmIntegrationPartialBuildState parse(String stringToParse) {
        throw new AssertionFailure("The partial build state cannot be parsed from a String;" + " it must be null or an instance of " + HibernateOrmIntegrationPartialBuildState.class);
    }

    private final SearchIntegrationPartialBuildState integrationBuildState;

    private final HibernateOrmMappingKey mappingKey;

    HibernateOrmIntegrationPartialBuildState(SearchIntegrationPartialBuildState integrationBuildState, HibernateOrmMappingKey mappingKey) {
        this.integrationBuildState = integrationBuildState;
        this.mappingKey = mappingKey;
    }

    public void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void set(BiConsumer<String, Object> propertyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    HibernateSearchContextProviderService doBootSecondPhase(SessionFactoryImplementor sessionFactoryImplementor, ConfigurationPropertySource propertySource, ConfigurationPropertyChecker propertyChecker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
