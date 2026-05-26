/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.spi;

import org.hibernate.search.engine.search.projection.spi.SearchProjectionIndexScope;

/**
 * Represents the current context in the search DSL,
 * including in particular the search scope and the projection builder factory.
 *
 * @param <SC> The type of the backend-specific search scope.
 */
public final class SearchProjectionDslContext<SC extends SearchProjectionIndexScope<?>> {

    public static <SC extends SearchProjectionIndexScope<?>> SearchProjectionDslContext<SC> root(SC scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final SC scope;

    private SearchProjectionDslContext(SC scope) {
        this.scope = scope;
    }

    /**
     * @return The search scope. Will always return the exact same instance for a given DSL context.
     */
    public SC scope() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param newScope The new scope for the new DSL context.
     * @return A copy of this DSL context with its scope and predicate factory replaced with the given ones.
     */
    public SearchProjectionDslContext<SC> rescope(SC newScope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
