/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import java.util.List;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesSource;
import org.apache.lucene.search.CollectorManager;

public class NumericTermsCollectorFactory implements CollectorFactory<NumericTermsCollector, TermResults, NumericTermsCollectorManager> {

    public static CollectorFactory<NumericTermsCollector, TermResults, NumericTermsCollectorManager> instance(LongMultiValuesSource valuesSource, List<CollectorFactory<?, ?, ?>> collectorFactories) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final CollectorKey<NumericTermsCollector, TermResults> key = CollectorKey.create();

    private final LongMultiValuesSource valuesSource;

    private final List<CollectorFactory<?, ?, ?>> collectorFactories;

    public NumericTermsCollectorFactory(LongMultiValuesSource valuesSource, List<CollectorFactory<?, ?, ?>> collectorFactories) {
        this.valuesSource = valuesSource;
        this.collectorFactories = collectorFactories;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public NumericTermsCollectorManager createCollectorManager(CollectorExecutionContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<NumericTermsCollector, TermResults> getCollectorKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
