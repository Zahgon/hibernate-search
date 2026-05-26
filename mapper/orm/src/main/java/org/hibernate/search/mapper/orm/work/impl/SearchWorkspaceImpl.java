/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.work.impl;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.UnsupportedOperationBehavior;
import org.hibernate.search.mapper.orm.work.SearchWorkspace;
import org.hibernate.search.mapper.pojo.work.spi.PojoScopeWorkspace;
import org.hibernate.search.util.common.impl.Futures;

public class SearchWorkspaceImpl implements SearchWorkspace {

    private final PojoScopeWorkspace delegate;

    public SearchWorkspaceImpl(PojoScopeWorkspace delegate) {
        this.delegate = delegate;
    }

    @Override
    public void mergeSegments() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> mergeSegmentsAsync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void purge() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> purgeAsync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void purge(Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> purgeAsync(Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> flushAsync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> refreshAsync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
