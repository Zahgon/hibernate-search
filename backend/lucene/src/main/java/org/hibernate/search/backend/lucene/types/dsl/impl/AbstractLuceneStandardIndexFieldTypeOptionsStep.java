/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.types.dsl.LuceneStandardIndexFieldTypeOptionsStep;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.util.common.AssertionFailure;

/**
 * @param <S> The "self" type (the actual exposed type of this step).
 * @param <F> The type of field values.
 */
abstract class AbstractLuceneStandardIndexFieldTypeOptionsStep<S extends AbstractLuceneStandardIndexFieldTypeOptionsStep<?, F>, F> extends AbstractLuceneIndexFieldTypeOptionsStep<S, F> implements LuceneStandardIndexFieldTypeOptionsStep<S, F> {

    protected Projectable projectable = Projectable.DEFAULT;

    protected Searchable searchable = Searchable.DEFAULT;

    protected Aggregable aggregable = Aggregable.DEFAULT;

    protected F indexNullAsValue = null;

    AbstractLuceneStandardIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext, Class<F> valueType, DefaultStringConverters.Converter<F> defaultConverter) {
        super(buildContext, valueType);
        builder.parser(defaultConverter);
        builder.formatter(defaultConverter);
    }

    @Override
    public S projectable(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S indexNullAs(F indexNullAs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S searchable(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S aggregable(Aggregable aggregable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public abstract LuceneIndexValueFieldType<F> toIndexFieldType();

    protected static boolean resolveDefault(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean resolveDefault(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean resolveDefault(Sortable sortable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean resolveDefault(Aggregable aggregable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
