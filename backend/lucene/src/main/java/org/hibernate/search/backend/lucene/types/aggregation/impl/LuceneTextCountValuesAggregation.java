/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.Set;
import java.util.function.BiFunction;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl.CountDistinctTextValuesCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl.CountTextValuesCollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningTextMultiValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.engine.search.aggregation.spi.CountValuesAggregationBuilder;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementFactory;

public class LuceneTextCountValuesAggregation extends AbstractLuceneNestableAggregation<Long> {

    private final BiFunction<JoiningTextMultiValuesSource, String, CollectorFactory<?, Long, ?>> collectorFactorySupplier;

    private final Set<String> indexNames;

    private final String absoluteFieldPath;

    LuceneTextCountValuesAggregation(Builder builder) {
        super(builder);
        this.indexNames = builder.scope.hibernateSearchIndexNames();
        this.absoluteFieldPath = builder.field.absolutePath();
        this.collectorFactorySupplier = builder.collectorFactorySupplier;
    }

    public static Factory factory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static class Factory implements SearchQueryElementFactory<CountValuesAggregationBuilder.TypeSelector, LuceneSearchIndexScope<?>, LuceneSearchIndexNodeContext> {

        private static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override
        public CountValuesAggregationBuilder.TypeSelector create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void checkCompatibleWith(SearchQueryElementFactory<?, ?, ?> other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record TypeSelector(LuceneSearchIndexScope<?> scope, LuceneSearchIndexNodeContext node) implements CountValuesAggregationBuilder.TypeSelector {

        @Override
        public CountValuesAggregationBuilder builder() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public Extractor<Long> request(AggregationRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> indexNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static class Builder extends AbstractBuilder<Long> implements CountValuesAggregationBuilder {

        private BiFunction<JoiningTextMultiValuesSource, String, CollectorFactory<?, Long, ?>> collectorFactorySupplier;

        public Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<?> field) {
            super(scope, field);
            collectorFactorySupplier = CountTextValuesCollectorFactory::new;
        }

        @Override
        public void distinct(boolean distinct) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public AbstractLuceneNestableAggregation<Long> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record LuceneTextCountValuesAggregationExtractor(CollectorKey<?, Long> collectorKey) implements Extractor<Long> {

        @Override
        public Long extract(AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
