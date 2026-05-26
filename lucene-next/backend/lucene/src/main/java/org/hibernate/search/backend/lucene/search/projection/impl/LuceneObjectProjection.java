/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import java.io.IOException;
import java.util.Arrays;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TopDocsDataCollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.reporting.impl.LuceneSearchHints;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCompositeNodeSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.spi.ResultsCompositor;
import org.hibernate.search.util.common.SearchException;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.join.QueryBitSetProducer;
import org.apache.lucene.util.BitSet;

/**
 * A projection that yields one composite value per object in a given object field.
 * <p>
 * Not to be confused with {@link LuceneCompositeProjection}.
 *
 * @param <E> The type of the temporary storage for component values.
 * @param <V> The type of a single composed value.
 * @param <P> The type of the final projection result representing an accumulation of composed values of type {@code V}.
 */
public class LuceneObjectProjection<E, V, P> extends AbstractLuceneProjection<P> {

    private final String absoluteFieldPath;

    private final boolean nested;

    private final Query filter;

    private final String nestedDocumentPath;

    private final String requiredContextAbsoluteFieldPath;

    private final LuceneSearchProjection<?>[] inners;

    private final ResultsCompositor<E, V> compositor;

    private final ProjectionCollector.Provider<V, P> collectorProvider;

    public LuceneObjectProjection(Builder builder, LuceneSearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector.Provider<V, P> collectorProvider) {
        super(builder.scope);
        this.absoluteFieldPath = builder.objectField.absolutePath();
        this.nested = builder.objectField.type().nested();
        this.filter = builder.filter;
        this.nestedDocumentPath = builder.objectField.nestedDocumentPath();
        this.requiredContextAbsoluteFieldPath = collectorProvider.isSingleValued() ? builder.objectField.closestMultiValuedParentAbsolutePath() : null;
        this.inners = inners;
        this.compositor = compositor;
        this.collectorProvider = collectorProvider;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, P> request(ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param <A> The type of the temporary storage for accumulated values, before and after being composed.
     */
    private class ObjectFieldExtractor<A> implements Extractor<A, P> {

        private final String contextAbsoluteFieldPath;

        private final Extractor<?, ?>[] inners;

        private final ProjectionCollector<E, V, A, P> collector;

        private ObjectFieldExtractor(String contextAbsoluteFieldPath, Extractor<?, ?>[] inners, ProjectionCollector<E, V, A, P> collector) {
            this.contextAbsoluteFieldPath = contextAbsoluteFieldPath;
            this.inners = inners;
            this.collector = collector;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Values<A> values(ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private class ObjectFieldValues extends AbstractNestingAwareAccumulatingValues<E, A> {

            private final Values<?>[] inners;

            private final QueryBitSetProducer filterBitSetProducer;

            private BitSet filterMatchedBitSet;

            private ObjectFieldValues(TopDocsDataCollectorExecutionContext context, Values<?>[] inners) {
                super(contextAbsoluteFieldPath, nestedDocumentPath, ObjectFieldExtractor.this.collector, context);
                this.inners = inners;
                this.filterBitSetProducer = filter == null ? null : new QueryBitSetProducer(filter);
            }

            @Override
            public void context(LeafReaderContext context) throws IOException {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            protected A accumulate(A accumulated, int docId) throws IOException {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        @Override
        public final P transform(LoadingResult<?> loadingResult, A accumulated, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Factory extends AbstractLuceneCompositeNodeSearchQueryElementFactory<Builder> {

        @Override
        public Builder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexCompositeNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Builder implements CompositeProjectionBuilder {

        private final LuceneSearchIndexScope<?> scope;

        private final LuceneSearchIndexCompositeNodeContext objectField;

        private final Query filter;

        Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexCompositeNodeContext objectField, Query filter) {
            this.scope = scope;
            this.objectField = objectField;
            this.filter = filter;
        }

        @Override
        public <E, V, P> SearchProjection<P> build(SearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector.Provider<V, P> collectorProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
