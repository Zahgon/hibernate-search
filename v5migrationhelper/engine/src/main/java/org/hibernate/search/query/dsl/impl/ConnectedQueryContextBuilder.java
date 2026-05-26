/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.search.query.dsl.EntityContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.QueryContextBuilder;
import org.hibernate.search.scope.spi.V5MigrationSearchScope;
import org.hibernate.search.spi.SearchIntegrator;

/**
 * Assuming connection with the search factory
 *
 * @author Emmanuel Bernard
 */
public class ConnectedQueryContextBuilder implements QueryContextBuilder {

    private final SearchIntegrator integrator;

    public ConnectedQueryContextBuilder(SearchIntegrator integrator) {
        this.integrator = integrator;
    }

    @Override
    public EntityContext forEntity(Class<?> entityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final class HSearchEntityContext implements EntityContext {

        private final V5MigrationSearchScope scope;

        private final Map<String, String> analyzerOverrides = new HashMap<>();

        public HSearchEntityContext(Class<?> entityType) {
            this.scope = integrator.scope(entityType);
        }

        @Override
        public EntityContext overridesForField(String field, String analyzerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public QueryBuilder get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
