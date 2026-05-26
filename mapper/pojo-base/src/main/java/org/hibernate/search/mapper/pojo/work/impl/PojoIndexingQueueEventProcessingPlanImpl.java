/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.mapper.pojo.identity.impl.IdentifierMappingImplementor;
import org.hibernate.search.mapper.pojo.work.spi.DirtinessDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventPayload;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventProcessingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoTypeIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

public final class PojoIndexingQueueEventProcessingPlanImpl implements PojoIndexingQueueEventProcessingPlan {

    private final PojoWorkTypeContextProvider typeContextProvider;

    private final PojoWorkSessionContext sessionContext;

    private final PojoIndexingPlan delegate;

    public PojoIndexingQueueEventProcessingPlanImpl(PojoWorkTypeContextProvider typeContextProvider, PojoWorkSessionContext sessionContext, PojoIndexingPlan delegate) {
        this.typeContextProvider = typeContextProvider;
        this.sessionContext = sessionContext;
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
    public <I> String toSerializedId(String entityName, I identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object toIdentifier(String entityName, String serializedId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoWorkTypeContext<?, ?> typeContext(String entityName) {
        return typeContextProvider.byEntityName().getOrFail(entityName);
    }
}
