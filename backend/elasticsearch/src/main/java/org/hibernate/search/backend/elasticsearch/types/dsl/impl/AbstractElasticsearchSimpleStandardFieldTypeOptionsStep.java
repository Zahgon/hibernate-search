/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;

abstract class AbstractElasticsearchSimpleStandardFieldTypeOptionsStep<S extends AbstractElasticsearchSimpleStandardFieldTypeOptionsStep<?, F>, F> extends AbstractElasticsearchStandardIndexFieldTypeOptionsStep<S, F> {

    private Sortable sortable = Sortable.DEFAULT;

    protected boolean resolvedSortable;

    private Projectable projectable = Projectable.DEFAULT;

    protected boolean resolvedProjectable;

    private Searchable searchable = Searchable.DEFAULT;

    protected boolean resolvedSearchable;

    private Aggregable aggregable = Aggregable.DEFAULT;

    protected boolean resolvedAggregable;

    private F indexNullAs;

    AbstractElasticsearchSimpleStandardFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext, Class<F> fieldType, String dataType, DefaultStringConverters.Converter<F> defaultConverter) {
        super(buildContext, fieldType);
        builder.mapping().setType(dataType);
        builder.parser(defaultConverter);
        builder.formatter(defaultConverter);
    }

    @Override
    public S projectable(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S sortable(Sortable sortable) {
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
    public final IndexFieldType<F> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract void complete();
}
