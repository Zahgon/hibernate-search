/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.util.Objects;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.types.converter.LuceneFieldContributor;
import org.hibernate.search.backend.lucene.types.converter.LuceneFieldValueExtractor;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.index.IndexableField;

public final class LuceneFieldFieldCodec<F> implements LuceneFieldCodec<F, F> {

    private final LuceneFieldContributor<F> fieldContributor;

    private final LuceneFieldValueExtractor<F> fieldValueExtractor;

    private final Class<F> valueClass;

    public LuceneFieldFieldCodec(Class<F> valueClass, LuceneFieldContributor<F> fieldContributor, LuceneFieldValueExtractor<F> fieldValueExtractor) {
        this.valueClass = valueClass;
        this.fieldContributor = fieldContributor;
        this.fieldValueExtractor = fieldValueExtractor;
    }

    @Override
    public void addToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F decode(F field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F encode(F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<F> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(LuceneFieldCodec<?, ?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void contributeField(LuceneDocumentContent documentBuilder, String absoluteFieldPath, IndexableField field) {
        if (!absoluteFieldPath.equals(field.name())) {
            throw IndexingLog.INSTANCE.invalidFieldPath(absoluteFieldPath, field.name());
        }
        documentBuilder.addField(field);
    }
}
