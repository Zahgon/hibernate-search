/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.search.loading.impl;

import java.util.Map;
import org.hibernate.search.engine.backend.common.DocumentReference;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.common.spi.PojoEntityReferenceFactoryDelegate;
import org.hibernate.search.mapper.pojo.loading.impl.PojoLoadingPlan;
import org.hibernate.search.mapper.pojo.logging.impl.LoadingLog;

public final class PojoProjectionHitMapper<E> implements ProjectionHitMapper<E> {

    private final Map<String, PojoSearchLoadingIndexedTypeContext<? extends E>> targetTypesByEntityName;

    private final PojoEntityReferenceFactoryDelegate entityReferenceFactoryDelegate;

    private final BridgeSessionContext sessionContext;

    private final PojoLoadingPlan<E> loadingPlan;

    public PojoProjectionHitMapper(Map<String, PojoSearchLoadingIndexedTypeContext<? extends E>> targetTypesByEntityName, PojoEntityReferenceFactoryDelegate entityReferenceFactoryDelegate, BridgeSessionContext sessionContext, PojoLoadingPlan<E> loadingPlan) {
        this.targetTypesByEntityName = targetTypesByEntityName;
        this.entityReferenceFactoryDelegate = entityReferenceFactoryDelegate;
        this.sessionContext = sessionContext;
        this.loadingPlan = loadingPlan;
    }

    @Override
    public Object planLoading(DocumentReference reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LoadingResult<E> loadBlocking(Deadline deadline) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoSearchLoadingIndexedTypeContext<? extends E> toType(DocumentReference reference) {
        PojoSearchLoadingIndexedTypeContext<? extends E> type = targetTypesByEntityName.get(reference.typeName());
        if (type == null) {
            throw LoadingLog.INSTANCE.unexpectedEntityNameForEntityLoading(reference.typeName(), targetTypesByEntityName.keySet());
        }
        return type;
    }

    private Object toEntityIdentifier(PojoSearchLoadingIndexedTypeContext<?> type, DocumentReference reference) {
        return type.identifierMapping().fromDocumentIdentifier(reference.id(), sessionContext);
    }

    private EntityReference toEntityReference(PojoSearchLoadingIndexedTypeContext<?> type, DocumentReference reference) {
        return entityReferenceFactoryDelegate.create(type.typeIdentifier(), type.entityName(), toEntityIdentifier(type, reference));
    }

    private class SingleTypeLoadingResult implements LoadingResult<E> {

        private final PojoSearchLoadingIndexedTypeContext<? extends E> type;

        private SingleTypeLoadingResult(PojoSearchLoadingIndexedTypeContext<? extends E> type) {
            this.type = type;
        }

        @Override
        public E get(Object key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public EntityReference convertReference(DocumentReference reference) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class MultiTypeLoadingResult implements LoadingResult<E> {

        private MultiTypeLoadingResult() {
        }

        @Override
        public E get(Object key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public EntityReference convertReference(DocumentReference reference) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class TypeAndOrdinal<E> {

        private final PojoSearchLoadingIndexedTypeContext<? extends E> type;

        private final int ordinal;

        public TypeAndOrdinal(PojoSearchLoadingIndexedTypeContext<? extends E> type, int ordinal) {
            this.type = type;
            this.ordinal = ordinal;
        }
    }
}
