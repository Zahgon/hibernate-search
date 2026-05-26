/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.loading.impl;

import java.util.Set;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionEntityLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.loading.SelectionLoadingStrategy;

public class StandalonePojoSelectionLoadingStrategy<E> implements PojoSelectionLoadingStrategy<E> {

    private final SelectionLoadingStrategy<E> delegate;

    public StandalonePojoSelectionLoadingStrategy(SelectionLoadingStrategy<E> delegate) {
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
    public PojoSelectionEntityLoader<E> createEntityLoader(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, PojoSelectionLoadingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
