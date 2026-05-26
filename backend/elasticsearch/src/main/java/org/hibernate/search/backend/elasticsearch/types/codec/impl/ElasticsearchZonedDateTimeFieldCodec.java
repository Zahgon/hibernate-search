/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.hibernate.search.util.common.impl.TimeHelper;
import com.google.gson.Gson;

public class ElasticsearchZonedDateTimeFieldCodec extends AbstractElasticsearchJavaTimeFieldCodec<ZonedDateTime> {

    public ElasticsearchZonedDateTimeFieldCodec(Gson gson, DateTimeFormatter delegate) {
        super(gson, delegate);
    }

    @Override
    protected ZonedDateTime nullUnsafeParse(String stringValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Long nullUnsafeScalar(ZonedDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
