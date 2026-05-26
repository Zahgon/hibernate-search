/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.model.impl;

import java.util.function.Function;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchEncodingContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.engine.backend.document.model.spi.AbstractIndexValueField;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.hibernate.search.util.common.reporting.EventContext;

public final class LuceneIndexValueField<F> extends AbstractIndexValueField<LuceneIndexValueField<F>, LuceneSearchIndexScope<?>, LuceneIndexValueFieldType<F>, LuceneIndexCompositeNode, F> implements LuceneIndexField, LuceneSearchIndexValueFieldContext<F>, LuceneSearchEncodingContext<F> {

    private final boolean dynamic;

    public LuceneIndexValueField(LuceneIndexCompositeNode parent, String relativeFieldName, LuceneIndexValueFieldType<F> type, TreeNodeInclusion inclusion, boolean multiValued, boolean dynamic) {
        super(parent, relativeFieldName, type, inclusion, multiValued);
        this.dynamic = dynamic;
    }

    @Override
    protected LuceneIndexValueField<F> self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexObjectField toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean dynamic() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> LuceneIndexValueField<? super T> withValueType(Class<T> expectedSubType, EventContext eventContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E, T> Function<T, E> encoder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field, LuceneFieldCodec<F, E> codec, Class<T> expectedType, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E convertAndEncode(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field, LuceneFieldCodec<F, E> codec, Object value, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(LuceneSearchEncodingContext<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchEncodingContext<F> encodingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
