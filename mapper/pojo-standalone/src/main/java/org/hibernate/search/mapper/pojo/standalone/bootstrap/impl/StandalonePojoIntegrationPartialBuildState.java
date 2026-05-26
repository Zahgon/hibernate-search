/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.bootstrap.impl;

import java.util.Optional;
import java.util.function.BiConsumer;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.ConfigurationPropertyChecker;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.common.spi.SearchIntegrationFinalizer;
import org.hibernate.search.engine.common.spi.SearchIntegrationPartialBuildState;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.standalone.cfg.spi.StandalonePojoMapperSpiSettings;
import org.hibernate.search.mapper.pojo.standalone.mapping.impl.StandalonePojoMapping;
import org.hibernate.search.mapper.pojo.standalone.mapping.impl.StandalonePojoMappingKey;
import org.hibernate.search.util.common.AssertionFailure;

final class StandalonePojoIntegrationPartialBuildState {

    private static final OptionalConfigurationProperty<StandalonePojoIntegrationPartialBuildState> INTEGRATION_PARTIAL_BUILD_STATE = ConfigurationProperty.forKey(StandalonePojoMapperSpiSettings.INTEGRATION_PARTIAL_BUILD_STATE).as(StandalonePojoIntegrationPartialBuildState.class, StandalonePojoIntegrationPartialBuildState::parse).build();

    public static Optional<StandalonePojoIntegrationPartialBuildState> get(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static StandalonePojoIntegrationPartialBuildState parse(String stringToParse) {
        throw new AssertionFailure("The partial build state cannot be parsed from a String;" + " it must be null or an instance of " + StandalonePojoIntegrationPartialBuildState.class);
    }

    private final SearchIntegrationPartialBuildState integrationBuildState;

    private final StandalonePojoMappingKey mappingKey;

    StandalonePojoIntegrationPartialBuildState(SearchIntegrationPartialBuildState integrationBuildState, StandalonePojoMappingKey mappingKey) {
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

    StandalonePojoMapping doBootSecondPhase(ConfigurationPropertySource propertySource, ConfigurationPropertyChecker propertyChecker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
