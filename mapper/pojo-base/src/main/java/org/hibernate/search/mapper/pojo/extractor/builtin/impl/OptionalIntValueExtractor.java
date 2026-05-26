/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.builtin.impl;

import java.util.OptionalInt;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractionContext;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;
import org.hibernate.search.mapper.pojo.extractor.ValueProcessor;
import org.hibernate.search.mapper.pojo.extractor.builtin.BuiltinContainerExtractors;

public class OptionalIntValueExtractor implements ContainerExtractor<OptionalInt, Integer> {

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T, C2> void extract(OptionalInt container, ValueProcessor<T, ? super Integer, C2> perValueProcessor, T target, C2 context, ContainerExtractionContext extractionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
