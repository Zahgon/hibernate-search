/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.Arrays;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCompositeNodeSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * A projection that yields one composite value per object in a given object field.
 * <p>
 * Not to be confused with {@link ElasticsearchCompositeProjection}.
 *
 * @param <E> The type of the temporary storage for component values.
 * @param <V> The type of a single composed value.
 * @param <P> The type of the final projection result representing an accumulation of composed values of type {@code V}.
 */
public class ElasticsearchObjectProjection<E, V, P> extends AbstractElasticsearchProjection<P> {

    private final String absoluteFieldPath;

    private final String[] absoluteFieldPathComponents;

    private final String requiredContextAbsoluteFieldPath;

    private final ElasticsearchSearchProjection<?>[] inners;

    private final ResultsCompositor<E, V> compositor;

    private final ProjectionCollector.Provider<V, P> collectorProvider;

    public ElasticsearchObjectProjection(Builder builder, ElasticsearchSearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector.Provider<V, P> collectorProvider) {
        super(builder.scope);
        this.absoluteFieldPath = builder.objectField.absolutePath();
        this.absoluteFieldPathComponents = builder.objectField.absolutePathComponents();
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
    public Extractor<?, P> request(JsonObject requestBody, ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param <A> The type of the temporary storage for accumulated values, before and after being composed.
     */
    private class ObjectFieldExtractor<A> extends AccumulatingSourceExtractor<E, V, A, P> {

        private final Extractor<?, ?>[] inners;

        private ObjectFieldExtractor(String[] fieldPathComponents, ProjectionCollector<E, V, A, P> collector, Extractor<?, ?>[] inners) {
            super(fieldPathComponents, collector);
            this.inners = inners;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected E extract(ProjectionHitMapper<?> projectionHitMapper, JsonObject hit, JsonElement sourceElement, ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean canDecodeArrays() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final P transform(LoadingResult<?> loadingResult, A accumulated, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Factory extends AbstractElasticsearchCompositeNodeSearchQueryElementFactory<Builder> {

        @Override
        public Builder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexCompositeNodeContext objectField) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Builder implements CompositeProjectionBuilder {

        private final ElasticsearchSearchIndexScope<?> scope;

        private final ElasticsearchSearchIndexCompositeNodeContext objectField;

        Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexCompositeNodeContext objectField) {
            this.scope = scope;
            this.objectField = objectField;
        }

        @Override
        public <E, V, P> SearchProjection<P> build(SearchProjection<?>[] inners, ResultsCompositor<E, V> compositor, ProjectionCollector.Provider<V, P> collectorProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
