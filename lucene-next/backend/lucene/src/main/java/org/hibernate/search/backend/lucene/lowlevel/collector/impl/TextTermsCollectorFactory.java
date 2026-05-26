/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import java.util.List;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.TextMultiValuesSource;
import org.apache.lucene.search.CollectorManager;

public class TextTermsCollectorFactory implements CollectorFactory<TextTermsCollector, TermResults, TextTermsCollectorManager> {

    public static CollectorFactory<TextTermsCollector, TermResults, TextTermsCollectorManager> instance(String field, TextMultiValuesSource valuesSource, List<CollectorFactory<?, ?, ?>> collectorFactories) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final CollectorKey<TextTermsCollector, TermResults> key = CollectorKey.create();

    private final TextMultiValuesSource valuesSource;

    private final String field;

    private final List<CollectorFactory<?, ?, ?>> collectorFactories;

    public TextTermsCollectorFactory(String field, TextMultiValuesSource valuesSource, List<CollectorFactory<?, ?, ?>> collectorFactories) {
        this.field = field;
        this.valuesSource = valuesSource;
        this.collectorFactories = collectorFactories;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public TextTermsCollectorManager createCollectorManager(CollectorExecutionContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<TextTermsCollector, TermResults> getCollectorKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
