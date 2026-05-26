/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.MatchNonePredicateBuilder;
import com.google.gson.JsonObject;

class ElasticsearchMatchNonePredicate extends AbstractElasticsearchPredicate {

    private static final JsonObjectAccessor MATCH_NONE_ACCESSOR = JsonAccessor.root().property("match_none").asObject();

    ElasticsearchMatchNonePredicate(AbstractBuilder builder) {
        super(builder);
    }

    @Override
    public void checkNestableWithin(PredicateNestingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder extends AbstractBuilder implements MatchNonePredicateBuilder {

        Builder(ElasticsearchSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
