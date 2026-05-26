/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.mapping.impl;

import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.OpenSearchVectorTypeMethod;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementFactory;
import org.hibernate.search.engine.search.predicate.spi.KnnPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.util.common.AssertionFailure;

abstract class AbstractOpenSearch2VectorFieldTypeMappingContributor implements ElasticsearchVectorFieldTypeMappingContributor {

    private static final String BYTE_TYPE = "BYTE";

    @Override
    public final void contribute(PropertyMapping mapping, Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final <F> void contribute(ElasticsearchIndexValueFieldType.Builder<F> builder, Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract <F> SearchQueryElementFactory<? extends KnnPredicateBuilder, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexValueFieldContext<F>> getKnnPredicateFactory(ElasticsearchIndexValueFieldType.Builder<F> builder);

    private static String resolveDefault(VectorSimilarity vectorSimilarity) {
        switch(vectorSimilarity) {
            case DEFAULT:
                return null;
            case L2:
                return "l2";
            case COSINE:
                return "cosinesimil";
            case DOT_PRODUCT:
            case MAX_INNER_PRODUCT:
                throw MappingLog.INSTANCE.vectorSimilarityNotSupportedByOpenSearchBackend(vectorSimilarity);
            default:
                throw new AssertionFailure("Unexpected value for Similarity: " + vectorSimilarity);
        }
    }
}
