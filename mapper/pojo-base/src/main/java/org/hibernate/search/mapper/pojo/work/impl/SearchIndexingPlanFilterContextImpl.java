/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.scope.impl.PojoScopeTypeContextProvider;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanFilterContext;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredSearchIndexingPlanFilter;

public class SearchIndexingPlanFilterContextImpl implements SearchIndexingPlanFilterContext {

    private final PojoScopeTypeContextProvider contextProvider;

    private final Set<PojoRawTypeIdentifier<?>> includes = new HashSet<>();

    private final Set<PojoRawTypeIdentifier<?>> excludes = new HashSet<>();

    public SearchIndexingPlanFilterContextImpl(PojoScopeTypeContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override
    public SearchIndexingPlanFilterContext include(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexingPlanFilterContext include(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexingPlanFilterContext exclude(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexingPlanFilterContext exclude(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfiguredSearchIndexingPlanFilter createFilter(ConfiguredSearchIndexingPlanFilter fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void exclude(Set<PojoRawTypeIdentifier<?>> allIncludes, Set<PojoRawTypeIdentifier<?>> allExcludes, Set<PojoRawTypeIdentifier<?>> processed, PojoRawTypeIdentifier<?> typeIdentifier) {
        contextProvider.forNonInterfaceSuperType(typeIdentifier).forEach(typeContext -> {
            PojoRawTypeIdentifier<?> identifier = typeContext.typeIdentifier();
            allIncludes.remove(identifier);
            allExcludes.add(identifier);
            processed.add(identifier);
        });
    }

    private void include(Set<PojoRawTypeIdentifier<?>> allIncludes, Set<PojoRawTypeIdentifier<?>> allExcludes, Set<PojoRawTypeIdentifier<?>> processed, PojoRawTypeIdentifier<?> typeIdentifier) {
        contextProvider.forNonInterfaceSuperType(typeIdentifier).forEach(typeContext -> {
            PojoRawTypeIdentifier<?> identifier = typeContext.typeIdentifier();
            allIncludes.add(identifier);
            allExcludes.remove(identifier);
            processed.add(identifier);
        });
    }

    private boolean addIfNotPresentInOther(PojoRawTypeIdentifier<?> typeIdentifier, Set<PojoRawTypeIdentifier<?>> a, Set<PojoRawTypeIdentifier<?>> b) {
        if (b.contains(typeIdentifier)) {
            throw IndexingLog.INSTANCE.indexingPlanFilterCannotIncludeExcludeSameType(typeIdentifier, includes, excludes);
        }
        return a.add(typeIdentifier);
    }
}
