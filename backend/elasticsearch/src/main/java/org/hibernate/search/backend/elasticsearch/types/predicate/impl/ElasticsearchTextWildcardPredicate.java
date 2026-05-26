/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.predicate.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.AbstractElasticsearchSingleFieldPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.WildcardPredicateBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ElasticsearchTextWildcardPredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonObjectAccessor WILDCARD_ACCESSOR = JsonAccessor.root().property("wildcard").asObject();

    private static final JsonAccessor<JsonElement> VALUE_ACCESSOR = JsonAccessor.root().property("value");

    private final JsonPrimitive pattern;

    public ElasticsearchTextWildcardPredicate(Builder builder) {
        super(builder);
        this.pattern = builder.pattern;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchValueFieldSearchQueryElementFactory<WildcardPredicateBuilder, String> {

        @Override
        public WildcardPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<String> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements WildcardPredicateBuilder {

        private JsonPrimitive pattern;

        private Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<String> field) {
            super(scope, field);
        }

        @Override
        public void pattern(String pattern) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
