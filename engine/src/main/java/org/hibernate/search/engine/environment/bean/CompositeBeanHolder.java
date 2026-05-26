/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.CollectionHelper;

final class CompositeBeanHolder<T> implements BeanHolder<List<T>> {

    private final List<? extends BeanHolder<? extends T>> dependencies;

    private final List<T> instances;

    CompositeBeanHolder(List<? extends BeanHolder<? extends T>> dependencies) {
        this.dependencies = dependencies;
        List<T> tmp = new ArrayList<>(dependencies.size());
        for (BeanHolder<? extends T> delegate : dependencies) {
            tmp.add(delegate.get());
        }
        this.instances = CollectionHelper.toImmutableList(tmp);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<T> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
