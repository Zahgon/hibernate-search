/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import java.util.Set;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCompositeNodeSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.NestedPredicateBuilder;
import com.google.gson.JsonObject;

public class ElasticsearchNestedPredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonAccessor<String> PATH_ACCESSOR = JsonAccessor.root().property("path").asString();

    private static final JsonAccessor<JsonObject> QUERY_ACCESSOR = JsonAccessor.root().property("query").asObject();

    private static final JsonAccessor<Boolean> IGNORE_UNMAPPED_ACCESSOR = JsonAccessor.root().property("ignore_unmapped").asBoolean();

    private final ElasticsearchSearchPredicate nestedPredicate;

    private ElasticsearchNestedPredicate(Builder builder) {
        super(builder);
        nestedPredicate = builder.nestedPredicate;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void wrap(Set<String> indexNames, String absoluteFieldPath, JsonObject outerObject, JsonObject innerObject, JsonObject toWrap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchCompositeNodeSearchQueryElementFactory<NestedPredicateBuilder> {

        @Override
        public NestedPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexCompositeNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements NestedPredicateBuilder {

        private ElasticsearchSearchPredicate nestedPredicate;

        Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexCompositeNodeContext field) {
            super(scope, field.absolutePath(), // nestedPathHierarchy includes absoluteFieldPath at the end, but here we don't want it to be included.
            field.nestedPathHierarchy().subList(0, field.nestedPathHierarchy().size() - 1));
        }

        @Override
        public void nested(SearchPredicate nestedPredicate) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
