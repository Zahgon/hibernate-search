/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;

public class CountDocuemntsCollectorFactory implements CollectorFactory<CountDocumentsCollector, Long, CountDocumentsCollectorManager> {

    private final CollectorKey<CountDocumentsCollector, Long> key = CollectorKey.create();

    public static CountDocuemntsCollectorFactory instance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountDocumentsCollectorManager createCollectorManager(CollectorExecutionContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<CountDocumentsCollector, Long> getCollectorKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
