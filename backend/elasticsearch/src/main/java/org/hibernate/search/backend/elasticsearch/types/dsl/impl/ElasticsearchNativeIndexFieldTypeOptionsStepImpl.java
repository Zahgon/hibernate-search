/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchRangeAggregation;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchTermsAggregation;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchExistsPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchRangePredicate;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldProjection;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchJsonElementFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.dsl.ElasticsearchNativeIndexFieldTypeOptionsStep;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchStandardMatchPredicate;
import org.hibernate.search.backend.elasticsearch.types.sort.impl.ElasticsearchStandardFieldSort;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

class ElasticsearchNativeIndexFieldTypeOptionsStepImpl extends AbstractElasticsearchIndexFieldTypeOptionsStep<ElasticsearchNativeIndexFieldTypeOptionsStepImpl, JsonElement> implements ElasticsearchNativeIndexFieldTypeOptionsStep<ElasticsearchNativeIndexFieldTypeOptionsStepImpl> {

    ElasticsearchNativeIndexFieldTypeOptionsStepImpl(ElasticsearchIndexFieldTypeBuildContext buildContext, PropertyMapping mapping) {
        super(buildContext, JsonElement.class, mapping);
    }

    @Override
    protected ElasticsearchNativeIndexFieldTypeOptionsStepImpl thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexFieldType<JsonElement> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
