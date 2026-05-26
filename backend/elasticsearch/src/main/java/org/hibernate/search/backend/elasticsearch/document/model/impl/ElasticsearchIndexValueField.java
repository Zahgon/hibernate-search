/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.impl;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.hibernate.search.backend.elasticsearch.logging.impl.IndexingLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchEncodingContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.backend.document.model.spi.AbstractIndexValueField;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.hibernate.search.util.common.reporting.EventContext;
import com.google.gson.JsonElement;

public final class ElasticsearchIndexValueField<F> extends AbstractIndexValueField<ElasticsearchIndexValueField<F>, ElasticsearchSearchIndexScope<?>, ElasticsearchIndexValueFieldType<F>, ElasticsearchIndexCompositeNode, F> implements ElasticsearchIndexField, ElasticsearchSearchIndexValueFieldContext<F>, ElasticsearchSearchEncodingContext<F> {

    public ElasticsearchIndexValueField(ElasticsearchIndexCompositeNode parent, String relativeFieldName, ElasticsearchIndexValueFieldType<F> type, TreeNodeInclusion inclusion, boolean multiValued) {
        super(parent, relativeFieldName, type, inclusion, multiValued);
    }

    @Override
    protected ElasticsearchIndexValueField<F> self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexObjectField toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> ElasticsearchIndexValueField<? super T> withValueType(Class<T> expectedSubType, EventContext eventContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Function<T, JsonElement> encoder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field, Class<T> expectedType, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public JsonElement convertAndEncode(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field, Object value, ValueModel valueModel, BiFunction<ElasticsearchFieldCodec<F>, F, JsonElement> encodeFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchSearchEncodingContext<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchEncodingContext<F> encodingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
