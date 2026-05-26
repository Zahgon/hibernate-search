/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.DocumentRouter;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

/**
 * @param <I> The identifier type for the mapped entity type.
 * @param <E> The entity type mapped to the index.
 */
public class PojoIndexedTypeIndexingPlan<I, E> extends AbstractPojoTypeIndexingPlan<I, E, PojoIndexedTypeIndexingPlan<I, E>.IndexedEntityState> {

    private final PojoWorkIndexedTypeContext<I, E> typeContext;

    public PojoIndexedTypeIndexingPlan(PojoWorkIndexedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingPlanImpl root, PojoTypeIndexingPlanDelegate<I, E> delegate) {
        super(sessionContext, root, delegate);
        this.typeContext = typeContext;
    }

    @Override
    void updateBecauseOfContained(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void resolveDirty(boolean deleteOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    PojoWorkIndexedTypeContext<I, E> typeContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    DocumentRouter<? super E> router() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected IndexedEntityState createState(I identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class IndexedEntityState extends AbstractPojoTypeIndexingPlan<I, E, IndexedEntityState>.AbstractEntityState {

        private DocumentRoutesDescriptor providedRoutes;

        private IndexedEntityState(I identifier) {
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
    }
}
