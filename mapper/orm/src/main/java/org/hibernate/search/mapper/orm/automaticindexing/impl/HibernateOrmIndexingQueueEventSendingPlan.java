/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.automaticindexing.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventPayload;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventSendingPlan;

public class HibernateOrmIndexingQueueEventSendingPlan implements PojoIndexingQueueEventSendingPlan {

    private final AutomaticIndexingQueueEventSendingPlan delegate;

    public HibernateOrmIndexingQueueEventSendingPlan(AutomaticIndexingQueueEventSendingPlan delegate) {
        this.delegate = delegate;
    }

    @Override
    public void append(String entityName, Object identifier, String serializedId, PojoIndexingQueueEventPayload payload) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void discard() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<MultiEntityOperationExecutionReport> sendAndReport(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
