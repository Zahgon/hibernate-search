/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import java.util.Collection;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesSource;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.EffectiveRange;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;

public class RangeCollectorManager implements CollectorManager<RangeCollector, RangeResults> {

    private final LongMultiValuesSource valuesSource;

    private final EffectiveRange[] ranges;

    private final CollectorKey<?, ?>[] keys;

    private final CollectorManager<Collector, ?>[] managers;

    public RangeCollectorManager(LongMultiValuesSource valuesSource, EffectiveRange[] ranges, CollectorKey<?, ?>[] keys, CollectorManager<Collector, ?>[] managers) {
        this.valuesSource = valuesSource;
        this.ranges = ranges;
        this.keys = keys;
        this.managers = managers;
    }

    @Override
    public RangeCollector newCollector() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeResults reduce(Collection<RangeCollector> collection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
