/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.SortedSetDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.util.BytesRef;

public final class LuceneStringFieldCodec implements LuceneFieldCodec<String, String> {

    private final FieldType mainFieldType;

    private final DocValues docValues;

    private final String indexNullAsValue;

    private final Analyzer analyzerOrNormalizer;

    public LuceneStringFieldCodec(FieldType mainFieldType, DocValues docValues, String indexNullAsValue, Analyzer analyzerOrNormalizer) {
        this.mainFieldType = mainFieldType;
        this.docValues = docValues;
        this.indexNullAsValue = indexNullAsValue;
        this.analyzerOrNormalizer = analyzerOrNormalizer;
    }

    @Override
    public void addToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String decode(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(LuceneFieldCodec<?, ?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String encode(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private BytesRef normalize(String absoluteFieldPath, String value) {
        if (value == null) {
            return null;
        }
        if (analyzerOrNormalizer == AnalyzerConstants.KEYWORD_ANALYZER) {
            // Optimization when analysis is disabled
            return new BytesRef(value);
        }
        return analyzerOrNormalizer.normalize(absoluteFieldPath, value);
    }

    public Class<String> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
