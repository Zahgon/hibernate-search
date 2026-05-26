/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.io.IOException;
import java.util.Collection;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningTextMultiValuesSource;
import com.carrotsearch.hppc.LongHashSet;
import org.apache.lucene.search.CollectorManager;

public class CountDistinctTextValuesCollectorManager implements CollectorManager<CountDistinctTextValuesCollector, Long> {

    private final JoiningTextMultiValuesSource source;

    private final String field;

    public CountDistinctTextValuesCollectorManager(JoiningTextMultiValuesSource source, String field) {
        this.source = source;
        this.field = field;
    }

    @Override
    public CountDistinctTextValuesCollector newCollector() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long reduce(Collection<CountDistinctTextValuesCollector> collectors) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
