/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.builtin.impl;

import java.util.Iterator;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractionContext;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;
import org.hibernate.search.mapper.pojo.extractor.ValueProcessor;

abstract class AbstractIteratorBasedElementExtractor<C, T> implements ContainerExtractor<C, T> {

    @Override
    public <T1, C2> void extract(C container, ValueProcessor<T1, ? super T, C2> perValueProcessor, T1 target, C2 context, ContainerExtractionContext extractionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Iterator<T> iterator(C container);
}
