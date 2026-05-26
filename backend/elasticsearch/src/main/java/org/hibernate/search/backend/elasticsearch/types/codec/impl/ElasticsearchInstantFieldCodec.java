/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import com.google.gson.Gson;

public class ElasticsearchInstantFieldCodec extends AbstractElasticsearchJavaTimeFieldCodec<Instant> {

    public ElasticsearchInstantFieldCodec(Gson gson, DateTimeFormatter delegate) {
        super(gson, delegate);
    }

    @Override
    protected String nullUnsafeFormat(Instant value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Instant nullUnsafeParse(String stringValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Long nullUnsafeScalar(Instant value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
