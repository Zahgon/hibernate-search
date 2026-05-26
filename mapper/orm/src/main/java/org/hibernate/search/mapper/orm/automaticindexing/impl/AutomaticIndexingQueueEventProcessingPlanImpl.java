/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.automaticindexing.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingQueueEventProcessingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventPayload;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventProcessingPlan;

public class AutomaticIndexingQueueEventProcessingPlanImpl implements AutomaticIndexingQueueEventProcessingPlan {

    private final PojoIndexingQueueEventProcessingPlan delegate;

    public AutomaticIndexingQueueEventProcessingPlanImpl(PojoIndexingQueueEventProcessingPlan delegate) {
        this.delegate = delegate;
    }

    @Override
    public void append(String entityName, String serializedId, PojoIndexingQueueEventPayload payload) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<MultiEntityOperationExecutionReport> executeAndReport(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toSerializedId(String entityName, Object identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object toIdentifier(String entityName, String serializedId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
