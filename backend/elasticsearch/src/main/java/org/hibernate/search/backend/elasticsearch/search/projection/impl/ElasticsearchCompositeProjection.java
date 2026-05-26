/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.Arrays;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;
import com.google.gson.JsonObject;

/**
 * A projection that composes the result of multiple inner projections into a single value.
 * <p>
 * Not to be confused with {@link ElasticsearchObjectProjection}.
 *
 * @param <E> The type of the temporary storage for component values.
 * @param <V> The type of a single composed value.
 * @param <A> The type of the temporary storage for accumulated values, before and after being composed.
 * @param <P> The type of the final projection result representing an accumulation of composed values of type {@code V}.
 */
class ElasticsearchCompositeProjection<E, V, A, P> extends AbstractElasticsearchProjection<P> {

    private final ElasticsearchSearchProjection<?>[] inners;

    private final ResultsCompositor<E, V> compositor;

    private final ProjectionCollector<E, V, A, P> collector;

    public ElasticsearchCompositeProjection(Builder builder, ElasticsearchSearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector<E, V, A, P> collector) {
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
    public Extractor<A, P> request(JsonObject requestBody, ProjectionRequestContext context) {
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
        public A extract(ProjectionHitMapper<?> projectionHitMapper, JsonObject hit, JsonObject source, ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final P transform(LoadingResult<?> loadingResult, A accumulated, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Builder implements CompositeProjectionBuilder {

        private final ElasticsearchSearchIndexScope<?> scope;

        Builder(ElasticsearchSearchIndexScope<?> scope) {
            this.scope = scope;
        }

        @Override
        public <E, V, P> SearchProjection<P> build(SearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector.Provider<V, P> collectorProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
