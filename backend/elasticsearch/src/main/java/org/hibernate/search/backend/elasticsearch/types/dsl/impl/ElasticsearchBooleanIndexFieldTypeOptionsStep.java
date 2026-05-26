/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchCountValuesAggregation;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchTermsAggregation;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchExistsPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchPredicateTypeKeys;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchRangePredicate;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldProjection;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchBooleanFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchStandardMatchPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTermsPredicate;
import org.hibernate.search.backend.elasticsearch.types.sort.impl.ElasticsearchStandardFieldSort;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;

class ElasticsearchBooleanIndexFieldTypeOptionsStep extends AbstractElasticsearchSimpleStandardFieldTypeOptionsStep<ElasticsearchBooleanIndexFieldTypeOptionsStep, Boolean> {

    ElasticsearchBooleanIndexFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext) {
        super(buildContext, Boolean.class, DataTypes.BOOLEAN, DefaultStringConverters.BOOLEAN);
    }

    @Override
    protected void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchBooleanIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
