/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.search.projection.impl.LuceneFieldProjection;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldFieldCodec;
import org.hibernate.search.backend.lucene.types.converter.LuceneFieldContributor;
import org.hibernate.search.backend.lucene.types.converter.LuceneFieldValueExtractor;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;

class LuceneNativeIndexFieldTypeOptionsStep<F> extends AbstractLuceneIndexFieldTypeOptionsStep<LuceneNativeIndexFieldTypeOptionsStep<F>, F> {

    private final LuceneFieldContributor<F> fieldContributor;

    private final LuceneFieldValueExtractor<F> fieldValueExtractor;

    LuceneNativeIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext, Class<F> fieldType, LuceneFieldContributor<F> fieldContributor, LuceneFieldValueExtractor<F> fieldValueExtractor) {
        super(buildContext, fieldType);
        this.fieldContributor = fieldContributor;
        this.fieldValueExtractor = fieldValueExtractor;
    }

    @Override
    public IndexFieldType<F> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneNativeIndexFieldTypeOptionsStep<F> thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
