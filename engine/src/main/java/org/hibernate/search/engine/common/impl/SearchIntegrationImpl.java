/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.Backend;
import org.hibernate.search.engine.backend.index.IndexManager;
import org.hibernate.search.engine.backend.index.spi.IndexManagerImplementor;
import org.hibernate.search.engine.backend.spi.BackendImplementor;
import org.hibernate.search.engine.common.resources.impl.EngineThreads;
import org.hibernate.search.engine.common.resources.spi.SavedState;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.common.spi.SearchIntegrationEnvironment;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.spi.BeanProvider;
import org.hibernate.search.engine.environment.thread.impl.ThreadPoolProviderImpl;
import org.hibernate.search.engine.logging.impl.ConfigurationLog;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingKey;
import org.hibernate.search.engine.mapper.mapping.spi.MappingImplementor;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.reporting.impl.EngineEventContextMessages;
import org.hibernate.search.engine.reporting.impl.EngineHints;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.reporting.spi.FailureCollector;
import org.hibernate.search.engine.reporting.spi.RootFailureCollector;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.Futures;
import org.hibernate.search.util.common.impl.Throwables;

public class SearchIntegrationImpl implements SearchIntegration {

    static final SavedState.Key<Map<String, SavedState>> INDEX_MANAGERS_KEY = SavedState.key("index_managers");

    private final BeanProvider beanProvider;

    private final BeanHolder<? extends FailureHandler> failureHandlerHolder;

    private final ThreadPoolProviderImpl threadPoolProvider;

    private final Map<MappingKey<?, ?>, MappingImplementor<?>> mappings;

    private final Map<String, BackendImplementor> backends;

    private final Map<String, IndexManagerImplementor> indexManagers;

    private final EngineThreads engineThreads;

    private final TimingSource timingSource;

    SearchIntegrationImpl(BeanProvider beanProvider, BeanHolder<? extends FailureHandler> failureHandlerHolder, ThreadPoolProviderImpl threadPoolProvider, Map<MappingKey<?, ?>, MappingImplementor<?>> mappings, Map<String, BackendImplementor> backends, Map<String, IndexManagerImplementor> indexManagers, EngineThreads engineThreads, TimingSource timingSource) {
        this.beanProvider = beanProvider;
        this.failureHandlerHolder = failureHandlerHolder;
        this.threadPoolProvider = threadPoolProvider;
        this.mappings = mappings;
        this.backends = backends;
        this.indexManagers = indexManagers;
        this.engineThreads = engineThreads;
        this.timingSource = timingSource;
    }

    @Override
    public Backend backend() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Backend backend(String backendName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexManager indexManager(String indexManagerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    SavedState saveForRestart() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Builder restartBuilder(SearchIntegrationEnvironment environment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <K, V> void stopAllSafely(Map<K, V> map, BiConsumer<V, ContextualFailureCollector> stop, FailureCollector failureCollector, BiFunction<FailureCollector, K, ContextualFailureCollector> appendEventContext) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            ContextualFailureCollector contextualFailureCollector = appendEventContext.apply(failureCollector, entry.getKey());
            try {
                stop.accept(entry.getValue(), contextualFailureCollector);
            } catch (RuntimeException e) {
                contextualFailureCollector.add(e);
            }
        }
    }

    private <K, V> void stopAllSafelyInParallel(Map<K, V> map, BiFunction<V, ContextualFailureCollector, CompletableFuture<?>> stop, FailureCollector failureCollector, BiFunction<FailureCollector, K, ContextualFailureCollector> appendEventContext) {
        CompletableFuture<?>[] futures = new CompletableFuture[map.size()];
        int i = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            ContextualFailureCollector contextualFailureCollector = appendEventContext.apply(failureCollector, entry.getKey());
            futures[i] = Futures.create(() -> stop.apply(entry.getValue(), contextualFailureCollector)).exceptionally(Futures.handler(throwable -> {
                Exception exception = Throwables.expectException(throwable);
                contextualFailureCollector.add(exception);
                return null;
            }));
            i++;
        }
        Futures.unwrappedExceptionJoin(CompletableFuture.allOf(futures));
    }
}
