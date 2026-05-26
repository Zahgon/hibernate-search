/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import java.util.List;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesSource;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.EffectiveRange;
import org.apache.lucene.search.CollectorManager;

public class RangeCollectorFactory implements CollectorFactory<RangeCollector, RangeResults, RangeCollectorManager> {

    public static CollectorFactory<RangeCollector, RangeResults, RangeCollectorManager> instance(LongMultiValuesSource valuesSource, EffectiveRange[] ranges, List<CollectorFactory<?, ?, ?>> collectorFactories) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final CollectorKey<RangeCollector, RangeResults> key = CollectorKey.create();

    private final LongMultiValuesSource valuesSource;

    private final EffectiveRange[] ranges;

    private final List<CollectorFactory<?, ?, ?>> collectorFactories;

    public RangeCollectorFactory(LongMultiValuesSource valuesSource, EffectiveRange[] ranges, List<CollectorFactory<?, ?, ?>> collectorFactories) {
        this.valuesSource = valuesSource;
        this.ranges = ranges;
        this.collectorFactories = collectorFactories;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public RangeCollectorManager createCollectorManager(CollectorExecutionContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<RangeCollector, RangeResults> getCollectorKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
