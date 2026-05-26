/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.time.Instant;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneOffsetTimeFieldCodec extends AbstractLuceneNumericFieldCodec<OffsetTime, Long> {

    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().append(LuceneLocalTimeFieldCodec.FORMATTER).// OffsetId is mandatory
    appendOffsetId().toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);

    public LuceneOffsetTimeFieldCodec(Indexing indexing, DocValues docValues, Storage storage, OffsetTime indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, OffsetTime value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OffsetTime decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(OffsetTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OffsetTime decode(Long encoded) {
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
