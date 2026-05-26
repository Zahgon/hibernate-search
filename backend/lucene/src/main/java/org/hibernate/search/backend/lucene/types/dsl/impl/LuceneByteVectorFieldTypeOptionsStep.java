/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.lowlevel.codec.impl.HibernateSearchKnnVectorsFormat;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneKnnPredicate;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneVectorFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Indexing;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneByteVectorCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Storage;
import org.hibernate.search.engine.search.predicate.spi.KnnPredicateBuilder;
import org.apache.lucene.index.VectorSimilarityFunction;

class LuceneByteVectorFieldTypeOptionsStep extends AbstractLuceneVectorFieldTypeOptionsStep<LuceneByteVectorFieldTypeOptionsStep, byte[]> {

    LuceneByteVectorFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext) {
        super(buildContext, byte[].class);
    }

    @Override
    protected LuceneByteVectorFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractLuceneValueFieldSearchQueryElementFactory<KnnPredicateBuilder, byte[]> knnPredicateFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractLuceneVectorFieldCodec<byte[]> createCodec(VectorSimilarityFunction vectorSimilarity, int dimension, Storage storage, Indexing indexing, byte[] indexNullAsValue, HibernateSearchKnnVectorsFormat knnVectorsFormat) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
