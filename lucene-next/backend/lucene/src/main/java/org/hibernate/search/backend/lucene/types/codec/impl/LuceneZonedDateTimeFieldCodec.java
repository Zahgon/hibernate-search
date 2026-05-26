/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Locale;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.hibernate.search.util.common.impl.TimeHelper;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneZonedDateTimeFieldCodec extends AbstractLuceneNumericFieldCodec<ZonedDateTime, Long> {

    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().append(LuceneOffsetDateTimeFieldCodec.FORMATTER).// ZoneRegionId is optional
    optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').optionalEnd().toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);

    public LuceneZonedDateTimeFieldCodec(Indexing indexing, DocValues docValues, Storage storage, ZonedDateTime indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, ZonedDateTime value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ZonedDateTime decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(ZonedDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ZonedDateTime decode(Long encoded) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNumericDomain<Long> getDomain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<Long> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
