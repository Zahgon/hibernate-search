/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.spi;

import java.util.List;
import java.util.function.Function;
import org.hibernate.search.engine.common.dsl.spi.DslExtensionState;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.AggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.dsl.AvgAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.CompositeAggregationInnerStep;
import org.hibernate.search.engine.search.aggregation.dsl.CountAggregationKindStep;
import org.hibernate.search.engine.search.aggregation.dsl.CountDistinctValuesAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.ExtendedSearchAggregationFactory;
import org.hibernate.search.engine.search.aggregation.dsl.MaxAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.MinAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.RangeAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.SearchAggregationFactoryExtension;
import org.hibernate.search.engine.search.aggregation.dsl.SumAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.TermsAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.impl.AvgAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.CompositeAggregationInnerStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.CountAggregationKindStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.CountDistinctValuesAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.MaxAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.MinAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.RangeAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.SumAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.TermsAggregationFieldStepImpl;
import org.hibernate.search.engine.search.aggregation.dsl.impl.WithParametersAggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.spi.SearchAggregationIndexScope;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;

public abstract class AbstractSearchAggregationFactory<SR, S extends ExtendedSearchAggregationFactory<SR, S, PDF>, SC extends SearchAggregationIndexScope<?>, PDF extends TypedSearchPredicateFactory<SR>> implements ExtendedSearchAggregationFactory<SR, S, PDF> {

    protected final SearchAggregationDslContext<SR, SC, PDF> dslContext;

    public AbstractSearchAggregationFactory(SearchAggregationDslContext<SR, SC, PDF> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public RangeAggregationFieldStep<SR, PDF> range() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsAggregationFieldStep<SR, PDF> terms() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SumAggregationFieldStep<SR, PDF> sum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MinAggregationFieldStep<SR, PDF> min() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MaxAggregationFieldStep<SR, PDF> max() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountAggregationKindStep<SR, PDF> count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(since = "8.1", forRemoval = true)
    @Override
    public CountDistinctValuesAggregationFieldStep<SR, PDF> countDistinct() {
        return new CountDistinctValuesAggregationFieldStepImpl<>(dslContext);
    }

    public AvgAggregationFieldStep<SR, PDF> avg() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeAggregationInnerStep composite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AggregationFinalStep<List<?>> composite(SearchAggregation<?>... aggregations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> AggregationFinalStep<T> withParameters(Function<? super NamedValues, ? extends AggregationFinalStep<T>> aggregationCreator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(SearchAggregationFactoryExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toAbsolutePath(String relativeFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
