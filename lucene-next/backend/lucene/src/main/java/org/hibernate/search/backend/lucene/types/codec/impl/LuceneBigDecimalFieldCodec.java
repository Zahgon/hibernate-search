/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.hibernate.search.engine.cfg.spi.NumberScaleConstants;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneBigDecimalFieldCodec extends AbstractLuceneNumericFieldCodec<BigDecimal, Long> {

    private final int decimalScale;

    private final BigDecimal minScaledValue;

    private final BigDecimal maxScaledValue;

    public LuceneBigDecimalFieldCodec(Indexing indexing, DocValues docValues, Storage storage, BigDecimal indexNullAsValue, int decimalScale) {
        super(indexing, docValues, storage, indexNullAsValue);
        this.decimalScale = decimalScale;
        this.minScaledValue = new BigDecimal(NumberScaleConstants.MIN_LONG_AS_BIGINTEGER, decimalScale);
        this.maxScaledValue = new BigDecimal(NumberScaleConstants.MAX_LONG_AS_BIGINTEGER, decimalScale);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, BigDecimal value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BigDecimal decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(BigDecimal value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BigDecimal decode(Long encoded) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNumericDomain<Long> getDomain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(LuceneFieldCodec<?, ?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Long unscale(BigDecimal value) {
        // See tck.DecimalScaleIT#roundingMode
        return value.setScale(decimalScale, RoundingMode.HALF_UP).unscaledValue().longValue();
    }

    private BigDecimal scale(Long value) {
        return new BigDecimal(BigInteger.valueOf(value), decimalScale);
    }

    public Class<Long> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double sortedDocValueToDouble(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
