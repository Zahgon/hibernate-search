/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.loading.impl;

import java.util.Set;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassEntityLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassEntityLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.loading.MassEntitySink;
import org.hibernate.search.mapper.pojo.standalone.loading.MassIdentifierSink;
import org.hibernate.search.mapper.pojo.standalone.loading.MassLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.massindexing.impl.StandalonePojoMassIndexingSessionContext;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class StandalonePojoMassLoadingStrategy<E, I> implements PojoMassLoadingStrategy<E, I> {

    private final MassLoadingStrategy<E, I> delegate;

    public StandalonePojoMassLoadingStrategy(MassLoadingStrategy<E, I> delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean groupingAllowed(PojoLoadingTypeContext<? extends E> type, PojoMassLoadingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIdentifierLoader createIdentifierLoader(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, PojoMassIdentifierLoadingContext<I> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassEntityLoader<I> createEntityLoader(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, PojoMassEntityLoadingContext<E> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
