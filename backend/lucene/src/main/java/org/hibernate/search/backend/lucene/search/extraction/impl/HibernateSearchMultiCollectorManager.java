/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.extraction.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.search.timeout.impl.LuceneCounterAdapter;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.apache.lucene.index.QueryTimeout;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.MultiCollector;
import org.apache.lucene.util.Counter;

public abstract class HibernateSearchMultiCollectorManager implements CollectorManager<Collector, HibernateSearchMultiCollectorManager.MultiCollectedResults> {

    protected HibernateSearchMultiCollectorManager(TimeoutManager timeoutManager) {
        this.timeoutManager = timeoutManager;
    }

    public static HibernateSearchMultiCollectorManager create(TimeoutManager timeoutManager, Map<CollectorKey<?, ?>, CollectorManager<Collector, ?>> collectorManagers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final TimeoutManager timeoutManager;

    public HibernateSearchQueryTimeout queryTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class HibernateSearchMultiCollectorManagerMulti extends HibernateSearchMultiCollectorManager {

        private final Map<CollectorKey<?, ?>, CollectorManager<Collector, ?>> collectorManagers;

        private HibernateSearchMultiCollectorManagerMulti(TimeoutManager timeoutManager, Map<CollectorKey<?, ?>, CollectorManager<Collector, ?>> collectorManagers) {
            super(timeoutManager);
            this.collectorManagers = collectorManagers;
        }

        @Override
        public Collector newCollector() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public MultiCollectedResults reduce(Collection<Collector> collectors) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class HibernateSearchMultiCollectorManagerSingle extends HibernateSearchMultiCollectorManager {

        private final CollectorKey<?, ?> key;

        private final CollectorManager<Collector, ?> collectorManager;

        private HibernateSearchMultiCollectorManagerSingle(TimeoutManager timeoutManager, CollectorKey<?, ?> key, CollectorManager<Collector, ?> collectorManager) {
            super(timeoutManager);
            this.key = key;
            this.collectorManager = collectorManager;
        }

        @Override
        public Collector newCollector() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public MultiCollectedResults reduce(Collection<Collector> collectors) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class MultiCollectedResults {

        public static final MultiCollectedResults EMPTY = new MultiCollectedResults(Collections.emptyMap());

        private final Map<CollectorKey<?, ?>, Object> results;

        public MultiCollectedResults(Map<CollectorKey<?, ?>, Object> results) {
            this.results = results;
        }

        @SuppressWarnings("unchecked")
        public <C extends Collector, T> T get(CollectorKey<C, T> key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    public static class Builder {

        private final CollectorExecutionContext executionContext;

        private final TimeoutManager timeoutManager;

        private final Map<CollectorKey<?, ?>, CollectorManager<Collector, ?>> components = new LinkedHashMap<>();

        public Builder(CollectorExecutionContext executionContext, TimeoutManager timeoutManager) {
            this.executionContext = executionContext;
            this.timeoutManager = timeoutManager;
        }

        public <C extends Collector, T> void add(CollectorKey<C, T> key, CollectorManager<? extends Collector, ? extends T> collectorManager) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void addAll(Set<CollectorFactory<?, ?, ?>> collectorFactories) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <C extends Collector, T, CM extends CollectorManager<C, T>> void add(CollectorFactory<C, T, CM> collectorFactory) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public HibernateSearchMultiCollectorManager build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class HibernateSearchQueryTimeout implements QueryTimeout {

        private final Deadline deadline;

        private final Counter clock;

        private final long baseline;

        private final long timeout;

        private boolean reached = false;

        public HibernateSearchQueryTimeout(TimeoutManager timeoutManager, Deadline deadline) {
            this.deadline = deadline;
            this.clock = new LuceneCounterAdapter(timeoutManager.timingSource());
            this.baseline = timeoutManager.timeoutBaseline();
            // The timeout starts from the given baseline, not from when the collector is first used.
            // This is important because some collectors are applied during a second search.
            this.timeout = baseline + deadline.checkRemainingTimeMillis();
        }

        public boolean isReached() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean shouldExit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
