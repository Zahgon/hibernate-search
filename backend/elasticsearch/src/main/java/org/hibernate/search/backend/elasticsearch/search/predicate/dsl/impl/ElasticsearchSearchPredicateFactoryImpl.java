/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.dsl.impl;

import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.search.predicate.dsl.ElasticsearchSearchPredicateFactory;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchSearchPredicateIndexScope;
import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.dsl.spi.StaticPredicateFinalStep;
import com.google.gson.JsonObject;

public class ElasticsearchSearchPredicateFactoryImpl<SR> extends AbstractSearchPredicateFactory<SR, ElasticsearchSearchPredicateFactory<SR>, ElasticsearchSearchPredicateIndexScope<?>> implements ElasticsearchSearchPredicateFactory<SR> {

    public ElasticsearchSearchPredicateFactoryImpl(Class<SR> scopeRootType, SearchPredicateDslContext<ElasticsearchSearchPredicateIndexScope<?>> dslContext) {
        super(scopeRootType, dslContext);
    }

    @Override
    public ElasticsearchSearchPredicateFactory<SR> withRoot(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // well because we check ;)
    @SuppressWarnings("unchecked")
    @Override
    public <SR2> ElasticsearchSearchPredicateFactory<SR2> withScopeRoot(Class<SR2> scopeRootType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateFinalStep fromJson(String jsonString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateFinalStep fromJson(JsonObject jsonObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
