/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningLongMultiValuesSource;

public class SumCollectorFactory implements CollectorFactory<AggregationFunctionCollector<Sum>, Long, AggregationFunctionCollectorManager<Sum>> {

    private final JoiningLongMultiValuesSource source;

    private final CollectorKey<AggregationFunctionCollector<Sum>, Long> key = CollectorKey.create();

    public SumCollectorFactory(JoiningLongMultiValuesSource source) {
        this.source = source;
    }

    @Override
    public AggregationFunctionCollectorManager<Sum> createCollectorManager(CollectorExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<AggregationFunctionCollector<Sum>, Long> getCollectorKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
