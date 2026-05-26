/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.massindexing.impl;

import org.hibernate.search.batchindexing.MassIndexerProgressMonitor;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingMonitor;

public class V5MigrationMassIndexerProgressMonitorAdapter implements MassIndexingMonitor {

    private final MassIndexerProgressMonitor delegate;

    public V5MigrationMassIndexerProgressMonitorAdapter(MassIndexerProgressMonitor delegate) {
        this.delegate = delegate;
    }

    @Override
    public void documentsBuilt(long increment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void entitiesLoaded(long increment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addToTotalCount(long increment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexingCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void documentsAdded(long increment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
