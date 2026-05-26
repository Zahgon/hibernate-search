/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.sort.dsl.spi;

import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.common.dsl.spi.DslExtensionState;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.reference.sort.FieldSortFieldReference;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.CompositeSortComponentsStep;
import org.hibernate.search.engine.search.sort.dsl.CompositeSortOptionsCollector;
import org.hibernate.search.engine.search.sort.dsl.DistanceSortOptionsStep;
import org.hibernate.search.engine.search.sort.dsl.ExtendedSearchSortFactory;
import org.hibernate.search.engine.search.sort.dsl.FieldSortOptionsGenericStep;
import org.hibernate.search.engine.search.sort.dsl.FieldSortOptionsStep;
import org.hibernate.search.engine.search.sort.dsl.ScoreSortOptionsStep;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactoryExtension;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactoryExtensionIfSupportedStep;
import org.hibernate.search.engine.search.sort.dsl.SortFinalStep;
import org.hibernate.search.engine.search.sort.dsl.SortThenStep;
import org.hibernate.search.engine.search.sort.dsl.impl.AbstractFieldSortOptionsGenericStep;
import org.hibernate.search.engine.search.sort.dsl.impl.CompositeSortComponentsStepImpl;
import org.hibernate.search.engine.search.sort.dsl.impl.DistanceSortOptionsStepImpl;
import org.hibernate.search.engine.search.sort.dsl.impl.ScoreSortOptionsStepImpl;
import org.hibernate.search.engine.search.sort.dsl.impl.SearchSortFactoryExtensionStep;
import org.hibernate.search.engine.search.sort.dsl.impl.WithParametersSortFinalStep;
import org.hibernate.search.engine.search.sort.spi.SearchSortIndexScope;
import org.hibernate.search.engine.spatial.GeoPoint;

public abstract class AbstractSearchSortFactory<SR, S extends ExtendedSearchSortFactory<SR, S, PDF>, SC extends SearchSortIndexScope<?>, PDF extends TypedSearchPredicateFactory<SR>> implements ExtendedSearchSortFactory<SR, S, PDF> {

    protected final SearchSortDslContext<SR, SC, PDF> dslContext;

    public AbstractSearchSortFactory(SearchSortDslContext<SR, SC, PDF> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public ScoreSortOptionsStep<SR, ?> score() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortThenStep<SR> indexOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FieldSortOptionsStep<SR, ?, PDF> field(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> FieldSortOptionsGenericStep<SR, T, ?, ?, ? extends TypedSearchPredicateFactory<SR>> field(FieldSortFieldReference<? super SR, T> fieldReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DistanceSortOptionsStep<SR, ?, PDF> distance(String fieldPath, GeoPoint location) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeSortComponentsStep<SR, ?> composite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortThenStep<SR> composite(Consumer<? super CompositeSortOptionsCollector<?>> elementContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortThenStep<SR> withParameters(Function<? super NamedValues, ? extends SortFinalStep> sortCreator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(SearchSortFactoryExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSortFactoryExtensionIfSupportedStep<SR> extension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toAbsolutePath(String relativeFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final SortThenStep<SR> staticThenStep(SearchSort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
