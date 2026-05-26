/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import java.util.Set;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import com.google.gson.JsonObject;

class ElasticsearchUserProvidedJsonPredicate implements ElasticsearchSearchPredicate {

    private final Set<String> indexNames;

    private final JsonObject json;

    ElasticsearchUserProvidedJsonPredicate(ElasticsearchSearchIndexScope<?> scope, JsonObject json) {
        indexNames = scope.hibernateSearchIndexNames();
        this.json = json;
    }

    @Override
    public Set<String> indexNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkNestableWithin(PredicateNestingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject toJsonQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
