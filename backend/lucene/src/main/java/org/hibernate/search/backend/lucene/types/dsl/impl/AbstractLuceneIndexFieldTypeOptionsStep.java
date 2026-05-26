/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeOptionsStep;
import org.hibernate.search.util.common.impl.Contracts;

abstract class AbstractLuceneIndexFieldTypeOptionsStep<S extends AbstractLuceneIndexFieldTypeOptionsStep<?, F>, F> implements IndexFieldTypeOptionsStep<S, F> {

    protected final LuceneIndexFieldTypeBuildContext buildContext;

    protected final LuceneIndexValueFieldType.Builder<F> builder;

    AbstractLuceneIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext, Class<F> valueType) {
        this.buildContext = buildContext;
        this.builder = new LuceneIndexValueFieldType.Builder<>(valueType);
    }

    @Override
    public <V> S dslConverter(Class<V> valueType, ToDocumentValueConverter<V, ? extends F> toIndexConverter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V> S projectionConverter(Class<V> valueType, FromDocumentValueConverter<? super F, V> fromIndexConverter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S parser(ToDocumentValueConverter<String, ? extends F> parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S formatter(FromDocumentValueConverter<? super F, String> formatter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract S thisAsS();
}
