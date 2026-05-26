/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.Set;
import java.util.function.Function;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.AggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.spi.WithParametersAggregationBuilder;
import org.hibernate.search.engine.search.common.NamedValues;

public class LuceneWithParametersAggregation<A> implements LuceneSearchAggregation<A> {

    private final LuceneSearchIndexScope<?> scope;

    private final Function<? super NamedValues, ? extends AggregationFinalStep<A>> aggregationCreator;

    private LuceneWithParametersAggregation(Builder<A> builder) {
        scope = builder.scope;
        aggregationCreator = builder.aggregationCreator;
    }

    @Override
    public Extractor<A> request(AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> indexNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder<A> implements WithParametersAggregationBuilder<A> {

        protected final LuceneSearchIndexScope<?> scope;

        private Function<? super NamedValues, ? extends AggregationFinalStep<A>> aggregationCreator;

        public Builder(LuceneSearchIndexScope<?> scope) {
            this.scope = scope;
        }

        @Override
        public LuceneSearchAggregation<A> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void creator(Function<? super NamedValues, ? extends AggregationFinalStep<A>> aggregationCreator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
