/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.loading.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalLong;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.mapper.pojo.standalone.loading.LoadingTypeGroup;
import org.hibernate.search.mapper.pojo.standalone.loading.MassEntityLoader;
import org.hibernate.search.mapper.pojo.standalone.loading.MassEntitySink;
import org.hibernate.search.mapper.pojo.standalone.loading.MassIdentifierLoader;
import org.hibernate.search.mapper.pojo.standalone.loading.MassIdentifierSink;
import org.hibernate.search.mapper.pojo.standalone.loading.MassLoadingOptions;
import org.hibernate.search.mapper.pojo.standalone.loading.MassLoadingStrategy;

public final class MapMassLoadingStrategy<E, I> implements MassLoadingStrategy<E, I> {

    private final Map<I, E> source;

    public MapMassLoadingStrategy(Map<I, E> source) {
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
    public MassIdentifierLoader createIdentifierLoader(LoadingTypeGroup<E> includedTypes, MassIdentifierSink<I> sink, MassLoadingOptions options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassEntityLoader<I> createEntityLoader(LoadingTypeGroup<E> includedTypes, MassEntitySink<E> sink, MassLoadingOptions options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
