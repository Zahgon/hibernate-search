/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchCountValuesAggregation;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchMetricFieldAggregation;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchRangeAggregation;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchTermsAggregation;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchExistsPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchPredicateTypeKeys;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchRangePredicate;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldProjection;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.format.impl.ElasticsearchDefaultFieldFormatProvider;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchStandardMatchPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTermsPredicate;
import org.hibernate.search.backend.elasticsearch.types.sort.impl.ElasticsearchStandardFieldSort;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;
import com.google.gson.Gson;

abstract class AbstractElasticsearchTemporalIndexFieldTypeOptionsStep<S extends AbstractElasticsearchTemporalIndexFieldTypeOptionsStep<?, F>, F extends TemporalAccessor> extends AbstractElasticsearchSimpleStandardFieldTypeOptionsStep<S, F> {

    AbstractElasticsearchTemporalIndexFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext, Class<F> fieldType, DefaultStringConverters.Converter<F> defaultConverter) {
        super(buildContext, fieldType, DataTypes.DATE, defaultConverter);
    }

    @Override
    protected final void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract ElasticsearchFieldCodec<F> createCodec(Gson gson, DateTimeFormatter formatter);

    protected boolean sumAggregationSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
