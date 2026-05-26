/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.util.Objects;
import java.util.function.Consumer;
import org.hibernate.search.backend.lucene.lowlevel.codec.impl.HibernateSearchKnnVectorsFormat;
import org.apache.lucene.codecs.KnnVectorsFormat;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.VectorEncoding;
import org.apache.lucene.index.VectorSimilarityFunction;
import org.apache.lucene.util.BytesRef;

public abstract class AbstractLuceneVectorFieldCodec<F> implements LuceneVectorFieldCodec<F> {

    protected final FieldType fieldType;

    protected final VectorSimilarityFunction vectorSimilarity;

    private final int dimension;

    private final Storage storage;

    private final Indexing indexing;

    private final F indexNullAsValue;

    private final HibernateSearchKnnVectorsFormat knnVectorsFormat;

    private final Consumer<F> checkVectorConsumer;

    protected AbstractLuceneVectorFieldCodec(VectorSimilarityFunction vectorSimilarity, int dimension, Storage storage, Indexing indexing, F indexNullAsValue, HibernateSearchKnnVectorsFormat knnVectorsFormat, Consumer<F> checkVectorConsumer) {
        this.vectorSimilarity = vectorSimilarity;
        this.dimension = dimension;
        this.storage = storage;
        this.indexing = indexing;
        this.indexNullAsValue = indexNullAsValue;
        this.knnVectorsFormat = knnVectorsFormat;
        this.checkVectorConsumer = checkVectorConsumer;
        this.fieldType = new FieldType();
        this.fieldType.setVectorAttributes(dimension, vectorEncoding(), vectorSimilarity);
        this.fieldType.freeze();
    }

    @Override
    public final void addToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private IndexableField toStoredField(String absoluteFieldPath, byte[] encodedValue) {
        return new StoredField(absoluteFieldPath, new BytesRef(encodedValue));
    }

    @Override
    public final F encode(F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F decode(F field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract byte[] toByteArray(F value);

    @Override
    public boolean isCompatibleWith(LuceneFieldCodec<?, ?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract IndexableField createIndexField(String absoluteFieldPath, F value);

    protected abstract VectorEncoding vectorEncoding();

    @Override
    public KnnVectorsFormat knnVectorFormat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getConfiguredDimensions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public VectorSimilarityFunction getVectorSimilarity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
