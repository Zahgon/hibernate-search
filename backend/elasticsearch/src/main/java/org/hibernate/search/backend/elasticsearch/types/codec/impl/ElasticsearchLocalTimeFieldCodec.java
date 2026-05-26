/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import com.google.gson.Gson;

public class ElasticsearchLocalTimeFieldCodec extends AbstractElasticsearchJavaTimeFieldCodec<LocalTime> {

    private static final LocalDate EPOCH_DAY = LocalDate.of(1970, Month.JANUARY, 1);

    public ElasticsearchLocalTimeFieldCodec(Gson gson, DateTimeFormatter delegate) {
        super(gson, delegate);
    }

    @Override
    protected LocalTime nullUnsafeParse(String stringValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Long nullUnsafeScalar(LocalTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
