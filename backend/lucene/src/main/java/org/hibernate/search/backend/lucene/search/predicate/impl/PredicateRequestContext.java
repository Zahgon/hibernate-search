/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.Optional;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryIndexScope;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.query.spi.QueryParameters;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Contracts;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;

public abstract class PredicateRequestContext {

    private final String nestedPath;

    private PredicateRequestContext(String nestedPath) {
        this.nestedPath = nestedPath;
    }

    public String getNestedPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract Query appendTenantAndRoutingFilters(Query originalFilterQuery);

    public abstract PredicateRequestContext withNestedPath(String nestedPath);

    public abstract NamedValues queryParameters();

    public static PredicateRequestContext withSession(LuceneSearchQueryIndexScope<?, ?> scope, BackendSessionContext sessionContext, Set<String> routingKeys, QueryParameters parameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static PredicateRequestContext withoutSession() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class LimitedPredicateRequestContext extends PredicateRequestContext {

        public LimitedPredicateRequestContext(String nestedPath) {
            super(nestedPath);
        }

        @Override
        public Query appendTenantAndRoutingFilters(Query originalFilterQuery) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PredicateRequestContext withNestedPath(String nestedPath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public NamedValues queryParameters() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class FailingQueryParameters implements NamedValues {

            private static final FailingQueryParameters INSTANCE = new FailingQueryParameters();

            @Override
            public <T> T get(String parameterName, Class<T> parameterValueType) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public <T> Optional<T> getOptional(String parameterName, Class<T> parameterValueType) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class FullPredicateRequestContext extends PredicateRequestContext {

        private final LuceneSearchQueryIndexScope<?, ?> scope;

        private final BackendSessionContext sessionContext;

        private final Set<String> routingKeys;

        private final QueryParameters parameters;

        private FullPredicateRequestContext(String nestedPath, LuceneSearchQueryIndexScope<?, ?> scope, BackendSessionContext sessionContext, Set<String> routingKeys, QueryParameters parameters) {
            super(nestedPath);
            this.scope = scope;
            this.sessionContext = sessionContext;
            this.routingKeys = routingKeys;
            this.parameters = parameters;
        }

        public Query appendTenantAndRoutingFilters(Query originalFilterQuery) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public PredicateRequestContext withNestedPath(String nestedPath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public NamedValues queryParameters() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
