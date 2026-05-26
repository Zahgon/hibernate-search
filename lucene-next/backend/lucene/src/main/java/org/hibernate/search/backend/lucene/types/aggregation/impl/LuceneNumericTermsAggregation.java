/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.NumericTermsCollector;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.NumericTermsCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TermResults;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningLongMultiValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.spi.TermsAggregationBuilder;
import org.hibernate.search.engine.search.common.ValueModel;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.search.DocIdSetIterator;

/**
 * @param <F> The type of field values.
 * @param <K> The type of keys in the returned map. It can be {@code F}
 * or a different type if value converters are used.
 */
public class LuceneNumericTermsAggregation<F, E extends Number, K, V, R> extends AbstractLuceneMultivaluedTermsAggregation<F, E, K, V, R> {

    private final LuceneNumericDomain<E> numericDomain;

    private final Comparator<E> termComparator;

    private final Function<E, V> decoder;

    private CollectorKey<NumericTermsCollector, TermResults> collectorKey;

    private LuceneNumericTermsAggregation(Builder<F, E, K, V, R> builder) {
        super(builder);
        this.numericDomain = builder.codec.getDomain();
        this.termComparator = numericDomain.createComparator();
        this.decoder = builder.decoder;
    }

    @Override
    public Extractor<Map<K, R>> request(AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory<F, E extends Number> extends AbstractLuceneCodecAwareSearchQueryElementFactory<TermsAggregationBuilder.TypeSelector, F, AbstractLuceneNumericFieldCodec<F, E>> {

        public Factory(AbstractLuceneNumericFieldCodec<F, E> codec) {
            super(codec);
        }

        @Override
        public TermsAggregationBuilder.TypeSelector create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class LuceneNumericTermsAggregationExtractor extends AbstractExtractor {

        private LuceneNumericTermsAggregationExtractor(Extractor<R> extractor) {
            super(extractor);
        }

        @Override
        protected TermResults termResults(AggregationExtractContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Comparator<E> getAscendingTermComparator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        V termToFieldValue(E key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        List<Bucket<E, R>> getTopBuckets(AggregationExtractContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Set<E> collectFirstTerms(IndexReader reader, boolean descending, int limit) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TypeSelector<F, E extends Number> extends AbstractTypeSelector<F> {

        private final AbstractLuceneNumericFieldCodec<F, E> codec;

        private TypeSelector(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.codec = codec;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <K> Builder<F, ?, K, ?, Long> type(Class<K> expectedType, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class CountBuilder<F, E extends Number, K, V> extends Builder<F, E, K, V, Long> {

        private CountBuilder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field, ProjectionConverter<V, ? extends K> fromFieldValueConverter, Function<E, V> decoder) {
            super(codec, scope, field, LuceneSearchAggregation.from(scope, LuceneCountDocumentAggregation.factory().create(scope, field).builder().build()), fromFieldValueConverter, decoder);
        }
    }

    private static class Builder<F, E extends Number, K, V, R> extends AbstractBuilder<F, E, K, V, R> {

        private final AbstractLuceneNumericFieldCodec<F, E> codec;

        private final Function<E, V> decoder;

        private Builder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field, LuceneSearchAggregation<R> aggregation, ProjectionConverter<V, ? extends K> fromFieldValueConverter, Function<E, V> decoder) {
            super(scope, field, aggregation, fromFieldValueConverter);
            this.codec = codec;
            this.decoder = decoder;
        }

        private Builder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<?> field, LuceneSearchAggregation<R> aggregation, ProjectionConverter<V, ? extends K> fromFieldValueConverter, Function<E, V> decoder, BucketOrder order, int minDocCount, int maxTermCount) {
            super(scope, field, aggregation, fromFieldValueConverter, order, minDocCount, maxTermCount);
            this.codec = codec;
            this.decoder = decoder;
        }

        @Override
        public LuceneNumericTermsAggregation<F, E, K, V, R> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <T> TermsAggregationBuilder<K, T> withValue(SearchAggregation<T> aggregation) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
