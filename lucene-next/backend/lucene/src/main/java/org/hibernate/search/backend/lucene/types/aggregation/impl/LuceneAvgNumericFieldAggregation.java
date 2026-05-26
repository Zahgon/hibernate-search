/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.List;
import org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl.CountValuesCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl.SumCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningLongMultiValuesSource;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.cfg.spi.NumberUtils;
import org.hibernate.search.engine.search.aggregation.spi.FieldMetricAggregationBuilder;

public class LuceneAvgNumericFieldAggregation<F, E extends Number, K> extends AbstractLuceneMetricNumericFieldAggregation<F, E, K> {

    public static <F> Factory<F> factory(AbstractLuceneNumericFieldCodec<F, ?> codec) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneAvgNumericFieldAggregation(Builder<F, E, K> builder) {
        super(builder);
    }

    @Override
    List<CollectorKey<?, Long>> fillCollectors(JoiningLongMultiValuesSource source, AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class LuceneNumericMetricFieldAggregationExtraction<F, E extends Number, K> implements Extractor<K> {

        private final CollectorKey<?, Long> collectorKey;

        private final CollectorKey<?, Long> countCollectorKey;

        private final AbstractLuceneNumericFieldCodec<F, E> codec;

        private final ProjectionConverter<F, ? extends K> fromFieldValueConverter;

        private LuceneNumericMetricFieldAggregationExtraction(CollectorKey<?, Long> collectorKey, CollectorKey<?, Long> countCollectorKey, AbstractLuceneNumericFieldCodec<F, E> codec, ProjectionConverter<F, ? extends K> fromFieldValueConverter) {
            this.collectorKey = collectorKey;
            this.countCollectorKey = countCollectorKey;
            this.codec = codec;
            this.fromFieldValueConverter = fromFieldValueConverter;
        }

        @Override
        public K extract(AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class Builder<F, E extends Number, K> extends AbstractExtractorBuilder<F, E, K> {

            private final ProjectionConverter<F, ? extends K> fromFieldValueConverter;

            private Builder(ProjectionConverter<F, ? extends K> fromFieldValueConverter) {
                this.fromFieldValueConverter = fromFieldValueConverter;
            }

            @Override
            Extractor<K> extractor(AbstractLuceneMetricNumericFieldAggregation<F, E, K> aggregation, List<CollectorKey<?, Long>> collectorKeys) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class LuceneNumericMetricFieldAggregationDoubleExtraction<F, E extends Number> implements Extractor<Double> {

        private final CollectorKey<?, Long> collectorKey;

        private final CollectorKey<?, Long> countCollectorKey;

        private final AbstractLuceneNumericFieldCodec<F, E> codec;

        private LuceneNumericMetricFieldAggregationDoubleExtraction(CollectorKey<?, Long> collectorKey, CollectorKey<?, Long> countCollectorKey, AbstractLuceneNumericFieldCodec<F, E> codec) {
            this.collectorKey = collectorKey;
            this.countCollectorKey = countCollectorKey;
            this.codec = codec;
        }

        @Override
        public Double extract(AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class Builder<F, E extends Number, K> extends AbstractExtractorBuilder<F, E, K> {

            @SuppressWarnings("unchecked")
            @Override
            Extractor<K> extractor(AbstractLuceneMetricNumericFieldAggregation<F, E, K> aggregation, List<CollectorKey<?, Long>> collectorKeys) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class LuceneNumericMetricFieldAggregationRawExtraction<E extends Number> implements Extractor<E> {

        private final CollectorKey<?, Long> collectorKey;

        private final CollectorKey<?, Long> countCollectorKey;

        private final AbstractLuceneNumericFieldCodec<?, E> codec;

        private LuceneNumericMetricFieldAggregationRawExtraction(CollectorKey<?, Long> collectorKey, CollectorKey<?, Long> countCollectorKey, AbstractLuceneNumericFieldCodec<?, E> codec) {
            this.collectorKey = collectorKey;
            this.countCollectorKey = countCollectorKey;
            this.codec = codec;
        }

        @Override
        public E extract(AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class Builder<F, E extends Number, K> extends AbstractExtractorBuilder<F, E, K> {

            @SuppressWarnings("unchecked")
            @Override
            Extractor<K> extractor(AbstractLuceneMetricNumericFieldAggregation<F, E, K> aggregation, List<CollectorKey<?, Long>> collectorKeys) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
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

        @Override
        protected <T> AbstractExtractorBuilder<F, E, T> extractor(ProjectionConverter<F, ? extends T> projectionConverter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected <T> AbstractExtractorBuilder<F, E, T> rawExtractor(ProjectionConverter<?, ? extends T> projectionConverter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected <T> AbstractExtractorBuilder<F, E, T> doubleExtractor() {
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
