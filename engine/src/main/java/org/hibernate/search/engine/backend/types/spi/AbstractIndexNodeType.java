/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.types.spi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.search.engine.backend.metamodel.IndexFieldTypeDescriptor;
import org.hibernate.search.engine.search.common.spi.SearchIndexNodeContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexNodeTypeContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementFactory;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;

public abstract class AbstractIndexNodeType<SC extends SearchIndexScope<?>, N extends SearchIndexNodeContext<SC>> implements IndexFieldTypeDescriptor, SearchIndexNodeTypeContext<SC, N> {

    private final Map<SearchQueryElementTypeKey<?>, SearchQueryElementFactory<?, ? super SC, ? super N>> queryElementFactories;

    private final Set<String> traits;

    protected AbstractIndexNodeType(Builder<SC, N> builder) {
        this.queryElementFactories = builder.queryElementFactories;
        TreeSet<String> modifiableTraits = new TreeSet<>();
        for (SearchQueryElementTypeKey<?> searchQueryElementTypeKey : queryElementFactories.keySet()) {
            String name = searchQueryElementTypeKey.name();
            modifiableTraits.add(name);
        }
        this.traits = Collections.unmodifiableSet(modifiableTraits);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> traits() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // The cast is safe by construction; see the builder.
    @SuppressWarnings("unchecked")
    @Override
    public final <T> SearchQueryElementFactory<? extends T, ? super SC, ? super N> queryElementFactory(SearchQueryElementTypeKey<T> key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract static class Builder<SC extends SearchIndexScope<?>, N extends SearchIndexNodeContext<SC>> {

        private final Map<SearchQueryElementTypeKey<?>, SearchQueryElementFactory<?, ? super SC, ? super N>> queryElementFactories = new HashMap<>();

        protected Builder() {
        }

        public final <T> void queryElementFactory(SearchQueryElementTypeKey<T> key, SearchQueryElementFactory<? extends T, ? super SC, ? super N> factory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public abstract AbstractIndexNodeType<SC, N> build();
    }
}
