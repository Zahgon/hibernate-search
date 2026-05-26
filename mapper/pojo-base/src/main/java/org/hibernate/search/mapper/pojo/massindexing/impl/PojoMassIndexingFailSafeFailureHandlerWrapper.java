/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import org.hibernate.search.mapper.pojo.logging.impl.MassIndexingLog;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEntityFailureContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureHandler;

public class PojoMassIndexingFailSafeFailureHandlerWrapper implements MassIndexingFailureHandler {

    private final MassIndexingFailureHandler delegate;

    private final boolean failFast;

    public PojoMassIndexingFailSafeFailureHandlerWrapper(MassIndexingFailureHandler delegate, boolean failFast) {
        this.delegate = delegate;
        this.failFast = failFast;
    }

    @Override
    public void handle(MassIndexingFailureContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void handle(MassIndexingEntityFailureContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long failureFloodingThreshold() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void failFastIfNeeded() {
        if (failFast) {
            throw MassIndexingLog.INSTANCE.massIndexerFailFast();
        }
    }
}
