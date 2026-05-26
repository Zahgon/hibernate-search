/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.backend.lucene.lowlevel.directory.impl.DirectoryCreationContextImpl;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryCreationContext;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryProvider;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.IOStrategy;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.IndexAccessorImpl;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneParallelWorkOrchestrator;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneParallelWorkOrchestratorImpl;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSerialWorkOrchestrator;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSerialWorkOrchestratorImpl;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.common.resources.spi.SavedState;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.index.DirectoryReader;

public final class Shard {

    private static final ConfigurationProperty<BeanReference<? extends DirectoryProvider>> DIRECTORY_TYPE = ConfigurationProperty.forKey(LuceneIndexSettings.DIRECTORY_TYPE).asBeanReference(DirectoryProvider.class).withDefault(BeanReference.of(DirectoryProvider.class, LuceneIndexSettings.Defaults.DIRECTORY_TYPE)).build();

    private static final SavedState.Key<DirectoryHolder> DIRECTORY_HOLDER_KEY = SavedState.key("directory_holder");

    private final Optional<String> shardId;

    private final IndexManagerBackendContext backendContext;

    private final LuceneIndexModel model;

    private DirectoryHolder directoryHolder;

    private IndexAccessorImpl indexAccessor;

    private LuceneParallelWorkOrchestratorImpl managementOrchestrator;

    private LuceneSerialWorkOrchestratorImpl indexingOrchestrator;

    private boolean savedForRestart = false;

    Shard(Optional<String> shardId, IndexManagerBackendContext backendContext, LuceneIndexModel model) {
        this.shardId = shardId;
        this.backendContext = backendContext;
        this.model = model;
    }

    public SavedState saveForRestart() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void preStart(ConfigurationPropertySource propertySource, BeanResolver beanResolver, SavedState savedState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void start(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<?> preStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    DirectoryReader openReader() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneSerialWorkOrchestrator indexingOrchestrator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneParallelWorkOrchestrator managementOrchestrator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexAccessorImpl indexAccessorForTests() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
