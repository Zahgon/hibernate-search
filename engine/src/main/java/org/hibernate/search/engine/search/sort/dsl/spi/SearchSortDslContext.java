/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.sort.dsl.spi;

import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.FieldSortOptionsStep;
import org.hibernate.search.engine.search.sort.dsl.SortThenStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;
import org.hibernate.search.engine.search.sort.spi.CompositeSortBuilder;
import org.hibernate.search.engine.search.sort.spi.SearchSortIndexScope;

/**
 * Represents the current context in the search DSL,
 * including in particular the search scope, the sort builder factory
 * and the knowledge of previous sorts chained using {@link SortThenStep#then()}.
 *
 * @param <SR> Scope root type.
 * @param <SC> The type of the backend-specific search scope.
 * @param <PDF> The type of factory used to create predicates in {@link FieldSortOptionsStep#filter(Function)}.
 */
public final class SearchSortDslContext<SR, SC extends SearchSortIndexScope<?>, PDF extends TypedSearchPredicateFactory<SR>> {

    public static <SR, SC extends SearchSortIndexScope<?>, PDF extends TypedSearchPredicateFactory<SR>> SearchSortDslContext<SR, SC, PDF> root(SC scope, Function<SearchSortDslContext<SR, SC, PDF>, TypedSearchSortFactory<SR>> factoryProvider, PDF predicateFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final SC scope;

    private final Function<SearchSortDslContext<SR, SC, PDF>, TypedSearchSortFactory<SR>> factoryProvider;

    private final SearchSortDslContext<SR, ?, ?> parent;

    private final SearchSort sort;

    private final PDF predicateFactory;

    private SearchSort compositeSort;

    private SearchSortDslContext(SC scope, Function<SearchSortDslContext<SR, SC, PDF>, TypedSearchSortFactory<SR>> factoryProvider, SearchSortDslContext<SR, ?, ?> parent, SearchSort sort, PDF predicateFactory) {
        this.scope = scope;
        this.factoryProvider = factoryProvider;
        this.parent = parent;
        this.sort = sort;
        this.predicateFactory = predicateFactory;
    }

    /**
     * @return The search scope.
     */
    public SC scope() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A new factory to be returned by {@link SortThenStep#then()}.
     */
    public TypedSearchSortFactory<SR> then() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param newScope The new scope for the new DSL context.
     * @param newPredicateFactory The new predicate factory for the new DSL context.
     * @return A copy of this DSL context with its scope and predicate factory replaced with the given ones.
     */
    public SearchSortDslContext<SR, SC, PDF> rescope(SC newScope, PDF newPredicateFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a new context with a sort appended.
     *
     * @param sort The sort to add.
     * @return A new DSL context, with the given builder appended.
     */
    public SearchSortDslContext<SR, SC, PDF> append(SearchSort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The predicate factory. Will always return the exact same instance.
     */
    public PDF predicateFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link SearchSort} instance
     * matching the definition given in the previous DSL steps.
     *
     * @return The {@link SearchSort} instance.
     */
    public SearchSort toSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SearchSort createCompositeSort() {
        if (parent == null) {
            // No sort at all; just use an empty composite sort.
            return scope.sortBuilders().composite().build();
        } else if (parent.sort == null) {
            // Only one element
            return sort;
        } else {
            CompositeSortBuilder builder = scope.sortBuilders().composite();
            collectSorts(builder);
            return builder.build();
        }
    }

    private void collectSorts(CompositeSortBuilder builder) {
        if (sort == null) {
            // We've reached the root
            return;
        }
        parent.collectSorts(builder);
        builder.add(sort);
    }
}
