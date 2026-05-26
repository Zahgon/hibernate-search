/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import static org.hibernate.search.engine.common.impl.SearchIntegrationImpl.INDEX_MANAGERS_KEY;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.index.spi.IndexManagerImplementor;
import org.hibernate.search.engine.backend.spi.BackendImplementor;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationPropertyChecker;
import org.hibernate.search.engine.common.resources.impl.EngineThreads;
import org.hibernate.search.engine.common.resources.spi.SavedState;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.common.spi.SearchIntegrationEnvironment;
import org.hibernate.search.engine.common.spi.SearchIntegrationFinalizer;
import org.hibernate.search.engine.common.spi.SearchIntegrationPartialBuildState;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.bean.spi.BeanProvider;
import org.hibernate.search.engine.environment.thread.impl.ThreadPoolProviderImpl;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingAbortedException;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingFinalizationContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingFinalizer;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingKey;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingPartialBuildState;
import org.hibernate.search.engine.mapper.mapping.spi.MappingImplementor;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.reporting.impl.EngineEventContextMessages;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.RootFailureCollector;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.Futures;

class SearchIntegrationPartialBuildStateImpl implements SearchIntegrationPartialBuildState {

    private final BeanProvider beanProvider;

    private final BeanResolver beanResolver;

    private final BeanHolder<? extends FailureHandler> failureHandlerHolder;

    private final ThreadPoolProviderImpl threadPoolProvider;

    private final Map<MappingKey<?, ?>, MappingPartialBuildState> partiallyBuiltMappings;

    private final Map<String, BackendNonStartedState> nonStartedBackends;

    private final Map<String, IndexManagerNonStartedState> nonStartedIndexManagers;

    private final ConfigurationPropertyChecker partialConfigurationPropertyChecker;

    private final Map<MappingKey<?, ?>, MappingNonStartedState> fullyBuiltNonStartedMappings = new LinkedHashMap<>();

    private final Map<String, BackendImplementor> startedBackends = new LinkedHashMap<>();

    private final Map<String, IndexManagerImplementor> startedIndexManagers = new LinkedHashMap<>();

    private final Map<MappingKey<?, ?>, MappingImplementor<?>> fullyBuiltStartedMappings = new LinkedHashMap<>();

    private final EngineThreads engineThreads;

    private final TimingSource timingSource;

    private final Optional<SearchIntegrationImpl> previousIntegration;

    SearchIntegrationPartialBuildStateImpl(BeanProvider beanProvider, BeanResolver beanResolver, BeanHolder<? extends FailureHandler> failureHandlerHolder, ThreadPoolProviderImpl threadPoolProvider, Map<MappingKey<?, ?>, MappingPartialBuildState> partiallyBuiltMappings, Map<String, BackendNonStartedState> nonStartedBackends, Map<String, IndexManagerNonStartedState> nonStartedIndexManagers, ConfigurationPropertyChecker partialConfigurationPropertyChecker, EngineThreads engineThreads, TimingSource timingSource, Optional<SearchIntegrationImpl> previousIntegration) {
        this.beanProvider = beanProvider;
        this.beanResolver = beanResolver;
        this.failureHandlerHolder = failureHandlerHolder;
        this.threadPoolProvider = threadPoolProvider;
        this.partiallyBuiltMappings = partiallyBuiltMappings;
        this.nonStartedBackends = nonStartedBackends;
        this.nonStartedIndexManagers = nonStartedIndexManagers;
        this.partialConfigurationPropertyChecker = partialConfigurationPropertyChecker;
        this.engineThreads = engineThreads;
        this.timingSource = timingSource;
        this.previousIntegration = previousIntegration;
    }

    @Override
    public void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIntegrationFinalizer finalizer(ConfigurationPropertySource propertySource, ConfigurationPropertyChecker configurationPropertyChecker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class SearchIntegrationFinalizerImpl implements SearchIntegrationFinalizer {

        private final RootFailureCollector failureCollector = new RootFailureCollector(EngineEventContextMessages.INSTANCE.bootstrap());

        private final ConfigurationPropertySource propertySource;

        private final ConfigurationPropertyChecker propertyChecker;

        private SearchIntegrationFinalizerImpl(ConfigurationPropertySource propertySource, ConfigurationPropertyChecker propertyChecker) {
            this.propertySource = propertySource;
            this.propertyChecker = propertyChecker;
        }

        @Override
        public <PBM, M> M finalizeMapping(MappingKey<PBM, M> mappingKey, MappingFinalizer<PBM, M> finalizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchIntegration finalizeIntegration() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
