/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningTextMultiValuesSource;

public class CountDistinctTextValuesCollectorFactory implements CollectorFactory<CountDistinctTextValuesCollector, Long, CountDistinctTextValuesCollectorManager> {

    private final JoiningTextMultiValuesSource source;

    private final String field;

    private final CollectorKey<CountDistinctTextValuesCollector, Long> key = CollectorKey.create();

    public CountDistinctTextValuesCollectorFactory(JoiningTextMultiValuesSource source, String field) {
        this.source = source;
        this.field = field;
    }

    @Override
    public CountDistinctTextValuesCollectorManager createCollectorManager(CollectorExecutionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<CountDistinctTextValuesCollector, Long> getCollectorKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
