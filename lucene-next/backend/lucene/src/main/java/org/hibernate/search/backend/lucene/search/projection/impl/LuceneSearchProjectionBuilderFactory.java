/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.search.backend.lucene.scope.model.impl.LuceneSearchIndexScopeImpl;
import org.hibernate.search.backend.lucene.search.projection.dsl.DocumentTree;
import org.hibernate.search.engine.backend.common.DocumentReference;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.common.spi.SearchIndexIdentifierContext;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.projection.spi.SearchProjectionBuilderFactory;
import org.hibernate.search.util.common.SearchException;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Explanation;

public class LuceneSearchProjectionBuilderFactory implements SearchProjectionBuilderFactory {

    private final LuceneSearchIndexScopeImpl<?> scope;

    public LuceneSearchProjectionBuilderFactory(LuceneSearchIndexScopeImpl<?> scope) {
        this.scope = scope;
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

    @SuppressWarnings("unchecked")
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

    public SearchProjection<Document> document() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchProjection<Explanation> explanation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchProjection<DocumentTree> documentTree() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
