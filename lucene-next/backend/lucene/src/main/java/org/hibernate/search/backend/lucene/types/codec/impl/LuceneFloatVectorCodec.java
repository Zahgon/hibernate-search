/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.function.Consumer;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.lowlevel.codec.impl.HibernateSearchKnnVectorsFormat;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.document.KnnFloatVectorField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.VectorEncoding;
import org.apache.lucene.index.VectorSimilarityFunction;
import org.apache.lucene.util.VectorUtil;

public class LuceneFloatVectorCodec extends AbstractLuceneVectorFieldCodec<float[]> {

    private static final float EPS = 1.0e-5f;

    public LuceneFloatVectorCodec(VectorSimilarityFunction vectorSimilarity, int dimension, Storage storage, Indexing indexing, float[] indexNullAsValue, HibernateSearchKnnVectorsFormat knnVectorsFormat) {
        super(vectorSimilarity, dimension, storage, indexing, indexNullAsValue, knnVectorsFormat, check(vectorSimilarity));
    }

    @Override
    public float[] decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public float[] raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<float[]> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected byte[] toByteArray(float[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected IndexableField createIndexField(String absoluteFieldPath, float[] value) {
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

    private static Consumer<float[]> check(VectorSimilarityFunction similarityFunction) {
        switch(similarityFunction) {
            case DOT_PRODUCT:
                return LuceneFloatVectorCodec::dotProductCheck;
            case COSINE:
                return LuceneFloatVectorCodec::cosineCheck;
            default:
                return LuceneFloatVectorCodec::noop;
        }
    }

    private static void cosineCheck(float[] vector) {
        float l1 = VectorUtil.dotProduct(vector, vector);
        if (l1 < EPS) {
            throw IndexingLog.INSTANCE.vectorCosineZeroMagnitudeNotAcceptable(Arrays.toString(vector));
        }
    }

    private static void dotProductCheck(float[] vector) {
        float l1 = VectorUtil.dotProduct(vector, vector);
        if (Math.abs(1 - Math.sqrt(l1)) > EPS) {
            throw IndexingLog.INSTANCE.vectorDotProductNonUnitMagnitudeNotAcceptable(Arrays.toString(vector));
        }
    }

    private static void noop(float[] vector) {
        // do nothing
    }
}
