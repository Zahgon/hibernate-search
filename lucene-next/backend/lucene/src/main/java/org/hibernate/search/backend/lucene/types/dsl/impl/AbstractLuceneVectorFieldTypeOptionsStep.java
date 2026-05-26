/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import static org.hibernate.search.backend.lucene.lowlevel.codec.impl.HibernateSearchKnnVectorsFormat.DEFAULT_MAX_DIMENSIONS;
import org.hibernate.search.backend.lucene.logging.impl.MappingLog;
import org.hibernate.search.backend.lucene.lowlevel.codec.impl.HibernateSearchKnnVectorsFormat;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneFieldProjection;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneVectorFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Indexing;
import org.hibernate.search.backend.lucene.types.codec.impl.Storage;
import org.hibernate.search.backend.lucene.types.dsl.LuceneVectorFieldTypeOptionsStep;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneExistsPredicate;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.engine.search.predicate.spi.KnnPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.index.VectorSimilarityFunction;

/**
 * @param <S> The "self" type (the actual exposed type of this step).
 * @param <F> The type of field values.
 */
abstract class AbstractLuceneVectorFieldTypeOptionsStep<S extends AbstractLuceneVectorFieldTypeOptionsStep<?, F>, F> extends AbstractLuceneIndexFieldTypeOptionsStep<S, F> implements LuceneVectorFieldTypeOptionsStep<S, F> {

    private static final int MAX_EF_CONSTRUCTION = 3200;

    private static final int MAX_M = 512;

    protected VectorSimilarity vectorSimilarity = VectorSimilarity.DEFAULT;

    protected Integer dimension;

    protected int efConstruction = 512;

    protected int m = 16;

    private Projectable projectable = Projectable.DEFAULT;

    private Searchable searchable = Searchable.DEFAULT;

    private F indexNullAsValue = null;

    AbstractLuceneVectorFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext, Class<F> valueType) {
        super(buildContext, valueType);
    }

    @Override
    public S projectable(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S searchable(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S vectorSimilarity(VectorSimilarity vectorSimilarity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S efConstruction(int efConstruction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S m(int m) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S dimension(int dimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S indexNullAs(F indexNullAsValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexValueFieldType<F> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract AbstractLuceneValueFieldSearchQueryElementFactory<KnnPredicateBuilder, F> knnPredicateFactory();

    protected abstract AbstractLuceneVectorFieldCodec<F> createCodec(VectorSimilarityFunction vectorSimilarity, int dimension, Storage storage, Indexing indexing, F indexNullAsValue, HibernateSearchKnnVectorsFormat knnVectorsFormat);

    private static VectorSimilarityFunction resolveDefault(VectorSimilarity vectorSimilarity) {
        switch(vectorSimilarity) {
            case DEFAULT:
            case L2:
                return VectorSimilarityFunction.EUCLIDEAN;
            case DOT_PRODUCT:
                return VectorSimilarityFunction.DOT_PRODUCT;
            case COSINE:
                return VectorSimilarityFunction.COSINE;
            case MAX_INNER_PRODUCT:
                return VectorSimilarityFunction.MAXIMUM_INNER_PRODUCT;
            default:
                throw new AssertionFailure("Unexpected value for Similarity: " + vectorSimilarity);
        }
    }

    protected static boolean resolveDefault(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean resolveDefault(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
