/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.util.Arrays;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.lowlevel.codec.impl.HibernateSearchKnnVectorsFormat;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.document.KnnByteVectorField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.VectorEncoding;
import org.apache.lucene.index.VectorSimilarityFunction;
import org.apache.lucene.util.VectorUtil;

public class LuceneByteVectorCodec extends AbstractLuceneVectorFieldCodec<byte[]> {

    public LuceneByteVectorCodec(VectorSimilarityFunction vectorSimilarity, int dimension, Storage storage, Indexing indexing, byte[] indexNullAsValue, HibernateSearchKnnVectorsFormat knnVectorsFormat) {
        super(vectorSimilarity, dimension, storage, indexing, indexNullAsValue, knnVectorsFormat, VectorSimilarityFunction.COSINE.equals(vectorSimilarity) ? LuceneByteVectorCodec::cosineCheck : LuceneByteVectorCodec::noop);
    }

    @Override
    public byte[] decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<byte[]> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected byte[] toByteArray(byte[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected IndexableField createIndexField(String absoluteFieldPath, byte[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected VectorEncoding vectorEncoding() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> vectorElementsType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public float similarityDistanceToScore(float distance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void cosineCheck(byte[] vector) {
        // means we cannot accept zero-vectors:
        for (byte b : vector) {
            if (b != 0) {
                return;
            }
        }
        // if we reached here means we had a vector of zeros so let's fail:
        throw IndexingLog.INSTANCE.vectorCosineZeroMagnitudeNotAcceptable(Arrays.toString(vector));
    }

    private static void noop(byte[] vector) {
        // do nothing
    }
}
