/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.common.NamedValues;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.Query;

class LocalAggregationRequestContext implements AggregationRequestContext {

    private final AggregationRequestContext delegate;

    private final Set<CollectorFactory<?, ?, ?>> localCollectorFactories = new LinkedHashSet<>();

    LocalAggregationRequestContext(AggregationRequestContext delegate) {
        this.delegate = delegate;
    }

    @Override
    public <C extends Collector, T, CM extends CollectorManager<C, T>> void requireCollector(CollectorFactory<C, T, CM> collectorFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NamedValues queryParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateRequestContext toPredicateRequestContext(String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NestedDocsProvider createNestedDocsProvider(String nestedDocumentPath, Query nestedFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<CollectorFactory<?, ?, ?>> localCollectorFactories() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AggregationRequestContext actualContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
