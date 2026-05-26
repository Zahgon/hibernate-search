/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.tree.impl;

import java.util.Optional;
import java.util.function.BiFunction;
import org.hibernate.search.engine.common.tree.TreeFilterDefinition;
import org.hibernate.search.engine.common.tree.spi.TreeFilterPathTracker;
import org.hibernate.search.engine.common.tree.spi.TreeNestingContext;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.mapper.model.spi.MappingElement;
import org.hibernate.search.util.common.SearchException;

public final class ConfiguredTreeNestingContext implements TreeNestingContext {

    public static final ConfiguredTreeNestingContext ROOT = new ConfiguredTreeNestingContext(TreeFilter.root(), "", "");

    private final TreeFilter filter;

    private final String prefixFromFilter;

    private final String unconsumedPrefix;

    private ConfiguredTreeNestingContext(TreeFilter filter, String prefixFromFilter, String unconsumedPrefix) {
        this.filter = filter;
        this.prefixFromFilter = prefixFromFilter;
        this.unconsumedPrefix = unconsumedPrefix;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T nest(String relativeName, LeafFactory<T> factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T nest(String relativeName, CompositeFactory<T> factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T nestUnfiltered(UnfilteredFactory<T> factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Optional<T> nestComposed(MappingElement mappingElement, String relativePrefix, TreeFilterDefinition definition, TreeFilterPathTracker pathTracker, NestedContextBuilder<T> contextBuilder, BiFunction<MappingElement, String, SearchException> cyclicRecursionExceptionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
