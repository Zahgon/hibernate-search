/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.EngineSettings;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.EngineSpiSettings;
import org.hibernate.search.engine.common.resources.impl.EngineThreads;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.common.spi.SearchIntegrationEnvironment;
import org.hibernate.search.engine.common.spi.SearchIntegrationPartialBuildState;
import org.hibernate.search.engine.common.timing.impl.DefaultTimingSource;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.thread.impl.ThreadPoolProviderImpl;
import org.hibernate.search.engine.environment.thread.spi.ThreadProvider;
import org.hibernate.search.engine.mapper.mapping.building.spi.BackendsInfo;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappedIndexManagerFactory;
import org.hibernate.search.engine.mapper.mapping.building.spi.Mapper;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingAbortedException;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingBuildContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingConfigurationCollector;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingInitiator;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingKey;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingPartialBuildState;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.engine.mapper.model.spi.TypeMetadataContributorProvider;
import org.hibernate.search.engine.mapper.model.spi.TypeMetadataDiscoverer;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.reporting.impl.EngineEventContextMessages;
import org.hibernate.search.engine.reporting.impl.FailSafeFailureHandlerWrapper;
import org.hibernate.search.engine.reporting.spi.RootFailureCollector;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class SearchIntegrationBuilder implements SearchIntegration.Builder {

    private static final ConfigurationProperty<BeanReference<? extends FailureHandler>> BACKGROUND_FAILURE_HANDLER = ConfigurationProperty.forKey(EngineSettings.Radicals.BACKGROUND_FAILURE_HANDLER).asBeanReference(FailureHandler.class).withDefault(EngineSettings.Defaults.BACKGROUND_FAILURE_HANDLER).build();

    private static final ConfigurationProperty<BeanReference<? extends ThreadProvider>> THREAD_PROVIDER = ConfigurationProperty.forKey(EngineSpiSettings.Radicals.THREAD_PROVIDER).asBeanReference(ThreadProvider.class).withDefault(EngineSpiSettings.Defaults.THREAD_PROVIDER).build();

    private final SearchIntegrationEnvironment environment;

    private final Optional<SearchIntegrationImpl> previousIntegration;

    private final Map<MappingKey<?, ?>, MappingInitiator<?, ?>> mappingInitiators = new LinkedHashMap<>();

    private boolean frozen = false;

    public SearchIntegrationBuilder(SearchIntegrationEnvironment environment, Optional<SearchIntegrationImpl> previousIntegration) {
        this.environment = environment;
        this.previousIntegration = previousIntegration;
        environment.propertyChecker().beforeBoot();
    }

    @Override
    public <PBM extends MappingPartialBuildState> SearchIntegration.Builder addMappingInitiator(MappingKey<PBM, ?> mappingKey, MappingInitiator<?, PBM> initiator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIntegrationPartialBuildState prepareBuild() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class MappingBuildingState<C, PBM extends MappingPartialBuildState> {

        private final MappingBuildContext buildContext;

        private final MappingKey<PBM, ?> mappingKey;

        private final MappingInitiator<C, PBM> mappingInitiator;

        private TypeMetadataContributorProvider<C> metadataContributorProvider;

        // Initially null, set in createMapper()
        private Mapper<PBM> mapper;

        MappingBuildingState(RootBuildContext rootBuildContext, MappingKey<PBM, ?> mappingKey, MappingInitiator<C, PBM> mappingInitiator) {
            this.mappingKey = mappingKey;
            this.buildContext = new MappingBuildContextImpl(rootBuildContext, mappingKey);
            this.mappingInitiator = mappingInitiator;
        }

        void collect() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void createMapper() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void determineIndexedTypes(BackendsInfo backendsInfo) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void mapIndexedTypes(MappedIndexManagerFactory indexManagerFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void partiallyBuildAndAddTo(Map<MappingKey<?, ?>, MappingPartialBuildState> mappings) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void closeOnFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private class MappingConfigurationCollectorImpl implements MappingConfigurationCollector<C> {

            private final TypeMetadataContributorProvider.Builder<C> builder;

            private MappingConfigurationCollectorImpl(TypeMetadataContributorProvider.Builder<C> builder) {
                this.builder = builder;
            }

            @Override
            public void collectContributor(MappableTypeModel typeModel, C contributor) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void collectDiscoverer(TypeMetadataDiscoverer<C> metadataDiscoverer) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}
