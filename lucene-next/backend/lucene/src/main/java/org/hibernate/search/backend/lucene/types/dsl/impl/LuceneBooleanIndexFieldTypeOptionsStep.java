/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.search.predicate.impl.LucenePredicateTypeKeys;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneFieldProjection;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LuceneCountValuesAggregation;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LuceneNumericTermsAggregation;
import org.hibernate.search.backend.lucene.types.codec.impl.DocValues;
import org.hibernate.search.backend.lucene.types.codec.impl.Indexing;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneBooleanFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Storage;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneExistsPredicate;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneNumericMatchPredicate;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneNumericRangePredicate;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneNumericTermsPredicate;
import org.hibernate.search.backend.lucene.types.sort.impl.LuceneStandardFieldSort;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;

class LuceneBooleanIndexFieldTypeOptionsStep extends AbstractLuceneStandardIndexFieldTypeOptionsStep<LuceneBooleanIndexFieldTypeOptionsStep, Boolean> {

    private Sortable sortable = Sortable.DEFAULT;

    LuceneBooleanIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext) {
        super(buildContext, Boolean.class, DefaultStringConverters.BOOLEAN);
    }

    @Override
    public LuceneBooleanIndexFieldTypeOptionsStep sortable(Sortable sortable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexValueFieldType<Boolean> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneBooleanIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
