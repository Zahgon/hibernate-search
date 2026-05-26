/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.backend.common.DocumentReference;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.common.spi.SearchIndexIdentifierContext;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.projection.spi.SearchProjectionBuilderFactory;
import org.hibernate.search.util.common.SearchException;
import com.google.gson.JsonObject;

public class ElasticsearchSearchProjectionBuilderFactory implements SearchProjectionBuilderFactory {

    private final ElasticsearchSearchIndexScope<?> scope;

    private final ProjectionExtractionHelper<String> mappedTypeNameExtractionHelper;

    private final DocumentReferenceExtractionHelper documentReferenceExtractionHelper;

    private final ProjectionExtractionHelper<String> idProjectionExtractionHelper;

    public ElasticsearchSearchProjectionBuilderFactory(SearchProjectionBackendContext searchProjectionBackendContext, ElasticsearchSearchIndexScope<?> scope) {
        this.scope = scope;
        this.mappedTypeNameExtractionHelper = searchProjectionBackendContext.createMappedTypeNameExtractionHelper(scope);
        this.documentReferenceExtractionHelper = searchProjectionBackendContext.createDocumentReferenceExtractionHelper(mappedTypeNameExtractionHelper);
        this.idProjectionExtractionHelper = searchProjectionBackendContext.idProjectionExtractionHelper();
    }

    @Override
    public SearchProjection<DocumentReference> documentReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <E> SearchProjection<E> entityLoading() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R> SearchProjection<R> entityReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I> SearchProjection<I> id(Class<I> requestedIdentifierType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjection<Float> score() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionBuilder composite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchProjection<T> constant(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchProjection<T> entityComposite(SearchProjection<T> delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchProjection<T> throwing(Supplier<SearchException> exceptionSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchProjection<T> byTypeName(Map<String, ? extends SearchProjection<? extends T>> inners) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchProjection<T> withParameters(Function<? super NamedValues, ? extends ProjectionFinalStep<T>> projectionCreator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchProjection<JsonObject> source() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchProjection<JsonObject> explanation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchProjection<JsonObject> jsonHit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
