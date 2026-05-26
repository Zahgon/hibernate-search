/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchLongFieldCodec;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;

class ElasticsearchLongIndexFieldTypeOptionsStep extends AbstractElasticsearchNumericFieldTypeOptionsStep<ElasticsearchLongIndexFieldTypeOptionsStep, Long> {

    ElasticsearchLongIndexFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext) {
        super(buildContext, Long.class, DataTypes.LONG, DefaultStringConverters.LONG);
    }

    @Override
    protected ElasticsearchFieldCodec<Long> completeCodec(ElasticsearchIndexFieldTypeBuildContext buildContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchLongIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
