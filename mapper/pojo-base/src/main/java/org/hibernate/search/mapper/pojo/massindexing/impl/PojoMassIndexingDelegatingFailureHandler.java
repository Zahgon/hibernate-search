/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.reporting.EntityIndexingFailureContext;
import org.hibernate.search.engine.reporting.FailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEntityFailureContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureHandler;

public class PojoMassIndexingDelegatingFailureHandler implements MassIndexingFailureHandler {

    private final FailureHandler delegate;

    public PojoMassIndexingDelegatingFailureHandler(FailureHandler delegate) {
        this.delegate = delegate;
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
}
