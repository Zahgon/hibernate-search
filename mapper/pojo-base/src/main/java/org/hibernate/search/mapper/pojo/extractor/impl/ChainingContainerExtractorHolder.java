/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.impl;

import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;
import org.hibernate.search.mapper.pojo.extractor.ValueProcessor;
import org.hibernate.search.util.common.impl.Closer;

final class ChainingContainerExtractorHolder<C, U, V> implements ContainerExtractorHolder<C, V> {

    private final ContainerExtractorHolder<C, U> base;

    private final BeanHolder<? extends ContainerExtractor<? super U, V>> chained;

    public ChainingContainerExtractorHolder(ContainerExtractorHolder<C, U> base, BeanHolder<? extends ContainerExtractor<? super U, V>> chained) {
        this.base = base;
        this.chained = chained;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T, C2> ValueProcessor<T, C, C2> wrap(ValueProcessor<T, ? super V, C2> perValueProcessor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendToString(StringBuilder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
