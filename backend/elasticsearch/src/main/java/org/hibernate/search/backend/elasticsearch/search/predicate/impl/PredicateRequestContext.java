/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import java.util.Set;
import org.hibernate.search.backend.elasticsearch.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.query.spi.QueryParameters;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PredicateRequestContext {

    private final BackendSessionContext sessionContext;

    private final ElasticsearchSearchIndexScope<?> searchIndexScope;

    private final Set<String> routingKeys;

    private final QueryParameters parameters;

    private final String nestedPath;

    public PredicateRequestContext(BackendSessionContext sessionContext, ElasticsearchSearchIndexScope<?> searchIndexScope, Set<String> routingKeys, QueryParameters parameters) {
        this(sessionContext, searchIndexScope, routingKeys, parameters, null);
    }

    private PredicateRequestContext(BackendSessionContext sessionContext, ElasticsearchSearchIndexScope<?> searchIndexScope, Set<String> routingKeys, QueryParameters parameters, String nestedPath) {
        this.sessionContext = sessionContext;
        this.searchIndexScope = searchIndexScope;
        this.routingKeys = routingKeys;
        this.parameters = parameters;
        this.nestedPath = nestedPath;
    }

    public String getNestedPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    String getTenantId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public JsonArray tenantAndRoutingFilters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PredicateRequestContext withNestedPath(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public NamedValues queryParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
