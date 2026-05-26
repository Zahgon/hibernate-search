/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.tree.impl;

import java.util.Optional;
import java.util.function.BiFunction;
import org.hibernate.search.engine.common.tree.TreeFilterDefinition;
import org.hibernate.search.engine.common.tree.spi.TreeContributionListener;
import org.hibernate.search.engine.common.tree.spi.TreeFilterPathTracker;
import org.hibernate.search.engine.common.tree.spi.TreeNestingContext;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.mapper.model.spi.MappingElement;
import org.hibernate.search.util.common.SearchException;

public final class NotifyingTreeNestingContext implements TreeNestingContext {

    private final TreeNestingContext delegate;

    private final TreeContributionListener listener;

    public NotifyingTreeNestingContext(TreeNestingContext delegate, TreeContributionListener listener) {
        this.delegate = delegate;
        this.listener = listener;
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
