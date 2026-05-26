/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Locale;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneLocalTimeFieldCodec extends AbstractLuceneNumericFieldCodec<LocalTime, Long> {

    static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().appendValue(HOUR_OF_DAY, 2).appendLiteral(':').appendValue(MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(SECOND_OF_MINUTE, 2).optionalStart().appendFraction(NANO_OF_SECOND, 3, 9, true).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);

    public LuceneLocalTimeFieldCodec(Indexing indexing, DocValues docValues, Storage storage, LocalTime indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, LocalTime value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalTime decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(LocalTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalTime decode(Long encoded) {
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
