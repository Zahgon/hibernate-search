/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.common.impl;

import java.util.List;
import java.util.Optional;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.engine.search.common.spi.AbstractMultiIndexSearchIndexValueFieldContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import com.google.gson.JsonPrimitive;

public class ElasticsearchMultiIndexSearchIndexValueFieldContext<F> extends AbstractMultiIndexSearchIndexValueFieldContext<ElasticsearchSearchIndexValueFieldContext<F>, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexValueFieldTypeContext<F>, F> implements ElasticsearchSearchIndexValueFieldContext<F>, ElasticsearchSearchIndexValueFieldTypeContext<F> {

    public ElasticsearchMultiIndexSearchIndexValueFieldContext(ElasticsearchSearchIndexScope<?> scope, String absolutePath, List<? extends ElasticsearchSearchIndexValueFieldContext<F>> fieldForEachIndex) {
        super(scope, absolutePath, fieldForEachIndex);
    }

    @Override
    protected ElasticsearchSearchIndexValueFieldContext<F> self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchIndexValueFieldTypeContext<F> selfAsNodeType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchIndexValueFieldTypeContext<F> typeOf(ElasticsearchSearchIndexValueFieldContext<F> indexElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchIndexCompositeNodeContext toComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchIndexCompositeNodeContext toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonPrimitive elasticsearchTypeAsJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> searchAnalyzerName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> normalizerName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasNormalizerOnAtLeastOneIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchFieldCodec<F> codec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchEncodingContext<F> encodingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
