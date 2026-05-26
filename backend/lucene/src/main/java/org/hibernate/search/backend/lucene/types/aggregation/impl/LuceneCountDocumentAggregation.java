/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.Set;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl.CountDocuemntsCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.aggregation.spi.CountDocumentAggregationBuilder;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementFactory;

public class LuceneCountDocumentAggregation implements LuceneSearchAggregation<Long> {

    private final Set<String> indexNames;

    private LuceneCountDocumentAggregation(Builder builder) {
        this.indexNames = builder.scope.hibernateSearchIndexNames();
    }

    public static Factory factory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static class Factory implements SearchQueryElementFactory<CountDocumentAggregationBuilder.TypeSelector, LuceneSearchIndexScope<?>, LuceneSearchIndexNodeContext> {

        private static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override
        public CountDocumentAggregationBuilder.TypeSelector create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void checkCompatibleWith(SearchQueryElementFactory<?, ?, ?> other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record TypeSelector(LuceneSearchIndexScope<?> scope, LuceneSearchIndexNodeContext node) implements CountDocumentAggregationBuilder.TypeSelector {

        @Override
        public CountDocumentAggregationBuilder builder() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public Extractor<Long> request(AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record CountDocumentsExtractor(CollectorKey<?, Long> collectorKey) implements Extractor<Long> {

        @Override
        public Long extract(AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public Set<String> indexNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record Builder(LuceneSearchIndexScope<?> scope) implements CountDocumentAggregationBuilder {

        @Override
        public LuceneCountDocumentAggregation build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
