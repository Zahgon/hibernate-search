/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.List;
import org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl.MinCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningLongMultiValuesSource;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.engine.search.aggregation.spi.FieldMetricAggregationBuilder;

public class LuceneMinNumericFieldAggregation<F, E extends Number, K> extends AbstractLuceneMetricNumericFieldAggregation<F, E, K> {

    public static <F> Factory<F> factory(AbstractLuceneNumericFieldCodec<F, ?> codec) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneMinNumericFieldAggregation(Builder<F, E, K> builder) {
        super(builder);
    }

    @Override
    List<CollectorKey<?, Long>> fillCollectors(JoiningLongMultiValuesSource source, AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory<F> extends AbstractLuceneCodecAwareSearchQueryElementFactory<FieldMetricAggregationBuilder.TypeSelector, F, AbstractLuceneNumericFieldCodec<F, ?>> {

        protected Factory(AbstractLuceneNumericFieldCodec<F, ?> codec) {
            super(codec);
        }

        @Override
        public FieldMetricAggregationBuilder.TypeSelector create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class FunctionTypeSelector<F, E extends Number> extends TypeSelector<F, E> implements FieldMetricAggregationBuilder.TypeSelector {

        protected FunctionTypeSelector(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(codec, scope, field);
        }

        @Override
        protected <T> Builder<F, E, T> getFtBuilder(AbstractExtractorBuilder<F, E, T> extractorCreator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F, E extends Number, K> extends AbstractLuceneMetricNumericFieldAggregation.Builder<F, E, K> {

        public Builder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field, AbstractExtractorBuilder<F, E, K> extractorCreator) {
            super(codec, scope, field, extractorCreator);
        }

        @Override
        public AbstractLuceneMetricNumericFieldAggregation<F, E, K> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
