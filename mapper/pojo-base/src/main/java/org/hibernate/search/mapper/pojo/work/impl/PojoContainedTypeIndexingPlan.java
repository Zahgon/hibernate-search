/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import org.hibernate.search.mapper.pojo.bridge.runtime.impl.DocumentRouter;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.NoOpDocumentRouter;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

/**
 * @param <I> The identifier type for the contained entity type.
 * @param <E> The contained entity type.
 */
public class PojoContainedTypeIndexingPlan<I, E> extends AbstractPojoTypeIndexingPlan<I, E, PojoContainedTypeIndexingPlan<I, E>.ContainedEntityState> {

    private final PojoWorkContainedTypeContext<I, E> typeContext;

    public PojoContainedTypeIndexingPlan(PojoWorkContainedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingPlanImpl root, PojoTypeIndexingPlanDelegate<I, E> delegate) {
        super(sessionContext, root, delegate);
        this.typeContext = typeContext;
    }

    @Override
    PojoWorkContainedTypeContext<I, E> typeContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    DocumentRouter<? super E> router() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ContainedEntityState createState(I identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class ContainedEntityState extends AbstractPojoTypeIndexingPlan<I, E, ContainedEntityState>.AbstractEntityState {

        private ContainedEntityState(I identifier) {
            super(identifier);
        }

        @Override
        void providedRoutes(DocumentRoutesDescriptor routes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        DocumentRoutesDescriptor providedRoutes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        void delegateDelete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
