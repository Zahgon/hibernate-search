/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import java.math.BigDecimal;
import org.hibernate.search.backend.lucene.logging.impl.MappingLog;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.DocValues;
import org.hibernate.search.backend.lucene.types.codec.impl.Indexing;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneBigDecimalFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Storage;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.backend.types.dsl.ScaledNumberIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexFieldTypeDefaultsProvider;

class LuceneBigDecimalIndexFieldTypeOptionsStep extends AbstractLuceneNumericIndexFieldTypeOptionsStep<LuceneBigDecimalIndexFieldTypeOptionsStep, BigDecimal> implements ScaledNumberIndexFieldTypeOptionsStep<LuceneBigDecimalIndexFieldTypeOptionsStep, BigDecimal> {

    private final IndexFieldTypeDefaultsProvider defaultsProvider;

    private Integer decimalScale = null;

    LuceneBigDecimalIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext, IndexFieldTypeDefaultsProvider defaultsProvider) {
        super(buildContext, BigDecimal.class, DefaultStringConverters.BIG_DECIMAL);
        this.defaultsProvider = defaultsProvider;
    }

    @Override
    public LuceneBigDecimalIndexFieldTypeOptionsStep decimalScale(int decimalScale) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneBigDecimalIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractLuceneNumericFieldCodec<BigDecimal, ?> createCodec(Indexing indexing, DocValues docValues, Storage storage, BigDecimal indexNullAsValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int resolveDecimalScale() {
        if (decimalScale != null) {
            return decimalScale;
        }
        if (defaultsProvider.decimalScale() != null) {
            return defaultsProvider.decimalScale();
        }
        throw MappingLog.INSTANCE.nullDecimalScale(buildContext.hints().missingDecimalScale(), buildContext.getEventContext());
    }
}
