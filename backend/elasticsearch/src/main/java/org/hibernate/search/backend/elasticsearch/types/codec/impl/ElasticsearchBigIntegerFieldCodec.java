/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import org.hibernate.search.backend.elasticsearch.logging.impl.IndexingLog;
import org.hibernate.search.engine.cfg.spi.NumberScaleConstants;
import org.hibernate.search.engine.cfg.spi.NumberUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public class ElasticsearchBigIntegerFieldCodec extends AbstractElasticsearchFieldCodec<BigInteger> {

    private final int decimalScale;

    private final BigDecimal scalingFactor;

    private final BigDecimal minScaledValue;

    private final BigDecimal maxScaledValue;

    public ElasticsearchBigIntegerFieldCodec(Gson gson, int decimalScale) {
        super(gson);
        this.decimalScale = decimalScale;
        scalingFactor = BigDecimal.TEN.pow(decimalScale, new MathContext(10, RoundingMode.HALF_UP));
        minScaledValue = new BigDecimal(NumberScaleConstants.MIN_LONG_AS_BIGINTEGER, decimalScale);
        maxScaledValue = new BigDecimal(NumberScaleConstants.MAX_LONG_AS_BIGINTEGER, decimalScale);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonElement encode(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BigInteger decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BigInteger decode(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BigInteger decodeAggregationKey(JsonElement key, JsonElement keyAsString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BigDecimal scalingFactor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
