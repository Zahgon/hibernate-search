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
import java.util.TreeSet;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TermResults;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TextTermsCollector;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TextTermsCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningTextMultiValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.spi.TermsAggregationBuilder;
import org.hibernate.search.engine.search.common.ValueModel;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.MultiDocValues;
import org.apache.lucene.index.SortedSetDocValues;

/**
 * @param <K> The type of keys in the returned map. It can be {@code String}
 * or a different type if value converters are used.
 */
public class LuceneTextTermsAggregation<K, R> extends AbstractLuceneMultivaluedTermsAggregation<String, String, K, String, R> {

    private static final Comparator<String> STRING_COMPARATOR = Comparator.naturalOrder();

    private CollectorKey<TextTermsCollector, TermResults> collectorKey;

    private LuceneTextTermsAggregation(Builder<K, R> builder) {
        super(builder);
    }

    @Override
    public Extractor<Map<K, R>> request(AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class LuceneTextTermsAggregationExtractor extends AbstractExtractor {

        private LuceneTextTermsAggregationExtractor(Extractor<R> extractor) {
            super(extractor);
        }

        @Override
        protected TermResults termResults(AggregationExtractContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Set<String> collectFirstTerms(IndexReader reader, boolean descending, int limit) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Comparator<String> getAscendingTermComparator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        String termToFieldValue(String key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        List<Bucket<String, R>> getTopBuckets(AggregationExtractContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Factory extends AbstractLuceneValueFieldSearchQueryElementFactory<TermsAggregationBuilder.TypeSelector, String> {

        @Override
        public TypeSelector create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<String> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TypeSelector extends AbstractTypeSelector<String> {

        private TypeSelector(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<String> field) {
            super(scope, field);
        }

        @SuppressWarnings("unchecked")
        @Override
        public <K> Builder<K, Long> type(Class<K> expectedType, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class CountBuilder<K> extends Builder<K, Long> {

        private CountBuilder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<String> field, ProjectionConverter<String, ? extends K> fromFieldValueConverter) {
            super(scope, field, LuceneSearchAggregation.from(scope, LuceneCountDocumentAggregation.factory().create(scope, field).builder().build()), fromFieldValueConverter);
        }
    }

    private static class Builder<K, V> extends AbstractBuilder<String, String, K, String, V> {

        private Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<String> field, LuceneSearchAggregation<V> aggregation, ProjectionConverter<String, ? extends K> fromFieldValueConverter) {
            super(scope, field, aggregation, fromFieldValueConverter);
        }

        private Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<?> field, LuceneSearchAggregation<V> aggregation, ProjectionConverter<String, ? extends K> fromFieldValueConverter, BucketOrder order, int minDocCount, int maxTermCount) {
            super(scope, field, aggregation, fromFieldValueConverter, order, minDocCount, maxTermCount);
        }

        @Override
        public LuceneTextTermsAggregation<K, V> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <T> TermsAggregationBuilder<K, T> withValue(SearchAggregation<T> aggregation) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
