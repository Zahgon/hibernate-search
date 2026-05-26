/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.Optional;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonArrayAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldTypeContext;
import org.hibernate.search.backend.elasticsearch.search.highlighter.impl.ElasticsearchSearchHighlighter;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterType;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.spi.HighlightProjectionBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ElasticsearchFieldHighlightProjection<T> implements ElasticsearchSearchProjection<T> {

    private static final JsonObjectAccessor REQUEST_HIGHLIGHT_FIELDS_ACCESSOR = JsonAccessor.root().property("highlight").asObject().property("fields").asObject();

    private final Set<String> indexNames;

    private final String absoluteFieldPath;

    private final String[] absoluteFieldPathComponents;

    private final String highlighterName;

    private final ElasticsearchSearchIndexValueFieldTypeContext<?> typeContext;

    private final ProjectionCollector.Provider<String, T> collectorProvider;

    private ElasticsearchFieldHighlightProjection(Builder builder, ProjectionCollector.Provider<String, T> collectorProvider) {
        this(builder.scope, builder.field, builder.highlighterName(), collectorProvider);
    }

    private ElasticsearchFieldHighlightProjection(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<?> field, String highlighterName, ProjectionCollector.Provider<String, T> collectorProvider) {
        this.indexNames = scope.hibernateSearchIndexNames();
        this.absoluteFieldPath = field.absolutePath();
        this.absoluteFieldPathComponents = field.absolutePathComponents();
        this.highlighterName = highlighterName;
        this.typeContext = field.type();
        this.collectorProvider = collectorProvider;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> indexNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, T> request(JsonObject requestBody, ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class FieldHighlightExtractor<A> implements Extractor<A, T> {

        private final JsonArrayAccessor highlightAccessor;

        private final ProjectionCollector<String, String, A, T> collector;

        private FieldHighlightExtractor(String fieldPath, ProjectionCollector<String, String, A, T> collector) {
            this.highlightAccessor = JsonAccessor.root().property("highlight").property(fieldPath).asArray();
            this.collector = collector;
        }

        @Override
        public A extract(ProjectionHitMapper<?> projectionHitMapper, JsonObject hit, JsonObject source, ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public T transform(LoadingResult<?> loadingResult, A extractedData, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Factory<F> extends AbstractElasticsearchValueFieldSearchQueryElementFactory<HighlightProjectionBuilder, F> {

        @Override
        public HighlightProjectionBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Builder extends HighlightProjectionBuilder {

        private final ElasticsearchSearchIndexScope<?> scope;

        private final ElasticsearchSearchIndexValueFieldContext<?> field;

        public Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<?> field) {
            super(field.absolutePath());
            this.scope = scope;
            this.field = field;
        }

        protected String highlighterName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <V> SearchProjection<V> build(ProjectionCollector.Provider<String, V> collectorProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
