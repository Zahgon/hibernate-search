/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.loading.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.mapper.pojo.standalone.loading.LoadingTypeGroup;
import org.hibernate.search.mapper.pojo.standalone.loading.SelectionEntityLoader;
import org.hibernate.search.mapper.pojo.standalone.loading.SelectionLoadingOptions;
import org.hibernate.search.mapper.pojo.standalone.loading.SelectionLoadingStrategy;

public final class MapSelectionLoadingStrategy<E, I> implements SelectionLoadingStrategy<E> {

    private final Map<I, E> source;

    public MapSelectionLoadingStrategy(Map<I, E> source) {
        this.source = source;
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
    public SelectionEntityLoader<E> createEntityLoader(LoadingTypeGroup<E> includedTypes, SelectionLoadingOptions options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
