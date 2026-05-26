/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.types.dsl.ElasticsearchStandardIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.util.common.AssertionFailure;

abstract class AbstractElasticsearchStandardIndexFieldTypeOptionsStep<S extends AbstractElasticsearchStandardIndexFieldTypeOptionsStep<?, F>, F> extends AbstractElasticsearchIndexFieldTypeOptionsStep<S, F> implements ElasticsearchStandardIndexFieldTypeOptionsStep<S, F> {

    AbstractElasticsearchStandardIndexFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext, Class<F> fieldType) {
        super(buildContext, fieldType, new PropertyMapping());
    }

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
