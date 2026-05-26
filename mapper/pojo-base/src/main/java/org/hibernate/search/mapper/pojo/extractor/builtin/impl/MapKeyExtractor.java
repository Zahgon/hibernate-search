/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.builtin.impl;

import java.util.Iterator;
import java.util.Map;
import org.hibernate.search.mapper.pojo.extractor.builtin.BuiltinContainerExtractors;

public class MapKeyExtractor<T> extends AbstractIteratorBasedElementExtractor<Map<T, ?>, T> {

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Iterator<T> iterator(Map<T, ?> container) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
