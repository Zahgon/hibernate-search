/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.reporting.impl;

import static org.hibernate.search.engine.logging.impl.EngineMiscLog.INSTANCE;
import org.hibernate.search.engine.reporting.EntityIndexingFailureContext;
import org.hibernate.search.engine.reporting.FailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;

public class FailSafeFailureHandlerWrapper implements FailureHandler {

    private final FailureHandler delegate;

    public FailSafeFailureHandlerWrapper(FailureHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public void handle(FailureContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void handle(EntityIndexingFailureContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long failureFloodingThreshold() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
