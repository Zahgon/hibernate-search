/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import java.io.IOException;
import java.util.Arrays;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;
import org.apache.lucene.index.LeafReaderContext;

/**
 * A projection that composes the result of multiple inner projections into a single value.
 * <p>
 * Not to be confused with {@link LuceneObjectProjection}.
 *
 * @param <E> The type of the temporary storage for component values.
 * @param <V> The type of a single composed value.
 * @param <A> The type of the temporary storage for accumulated values, before and after being composed.
 * @param <P> The type of the final projection result representing an accumulation of composed values of type {@code V}.
 */
class LuceneCompositeProjection<E, V, A, P> extends AbstractLuceneProjection<P> {

    private final LuceneSearchProjection<?>[] inners;

    private final ResultsCompositor<E, V> compositor;

    private final ProjectionCollector<E, V, A, P> collector;

    public LuceneCompositeProjection(Builder builder, LuceneSearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector<E, V, A, P> collector) {
        super(builder.scope);
        this.inners = inners;
        this.compositor = compositor;
        this.collector = collector;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, P> request(ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class CompositeExtractor implements Extractor<A, P> {

        private final Extractor<?, ?>[] inners;

        private CompositeExtractor(Extractor<?, ?>[] inners) {
            this.inners = inners;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Values<A> values(ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private class CompositeValues implements Values<A> {

            private final Values<?>[] inners;

            private CompositeValues(Values<?>[] inners) {
                this.inners = inners;
            }

            @Override
            public void context(LeafReaderContext context) throws IOException {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public A get(int doc) throws IOException {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        @Override
        public final P transform(LoadingResult<?> loadingResult, A accumulated, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Builder implements CompositeProjectionBuilder {

        private final LuceneSearchIndexScope<?> scope;

        Builder(LuceneSearchIndexScope<?> scope) {
            this.scope = scope;
        }

        @Override
        public <E, V, P> SearchProjection<P> build(SearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector.Provider<V, P> collectorProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
