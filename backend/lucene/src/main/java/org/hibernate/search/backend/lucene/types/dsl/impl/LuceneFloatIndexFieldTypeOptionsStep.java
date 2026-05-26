/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LuceneAvgCompensatedSumAggregation;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LuceneSumCompensatedSumAggregation;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.DocValues;
import org.hibernate.search.backend.lucene.types.codec.impl.Indexing;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFloatFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Storage;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.search.aggregation.spi.FieldMetricAggregationBuilder;

class LuceneFloatIndexFieldTypeOptionsStep extends AbstractLuceneNumericIndexFieldTypeOptionsStep<LuceneFloatIndexFieldTypeOptionsStep, Float> {

    LuceneFloatIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext) {
        super(buildContext, Float.class, DefaultStringConverters.FLOAT);
    }

    @Override
    protected LuceneFloatIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractLuceneNumericFieldCodec<Float, ?> createCodec(Indexing indexing, DocValues docValues, Storage storage, Float indexNullAsValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractLuceneCodecAwareSearchQueryElementFactory<FieldMetricAggregationBuilder.TypeSelector, Float, AbstractLuceneNumericFieldCodec<Float, ?>> sumMetricAggregationFactory(AbstractLuceneNumericFieldCodec<Float, ?> codec) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractLuceneCodecAwareSearchQueryElementFactory<FieldMetricAggregationBuilder.TypeSelector, Float, AbstractLuceneNumericFieldCodec<Float, ?>> avgMetricAggregationFactory(AbstractLuceneNumericFieldCodec<Float, ?> codec) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
