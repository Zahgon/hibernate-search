/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.impl;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;

final class IndexNamesRegistry {

    private final Map<String, IndexNames> indexNamesByName = new ConcurrentHashMap<>();

    void register(IndexNames newIndexNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
