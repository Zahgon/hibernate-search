/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.SimpleQueryStringDefinitionTermination;
import org.hibernate.search.query.dsl.SimpleQueryStringMatchingContext;
import org.hibernate.search.query.dsl.SimpleQueryStringTermination;

/**
 * @author Guillaume Smet
 */
public class ConnectedSimpleQueryStringMatchingContext implements SimpleQueryStringMatchingContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final FieldsContext fieldsContext;

    private boolean withAndAsDefaultOperator = false;

    public ConnectedSimpleQueryStringMatchingContext(String field, QueryCustomizer queryCustomizer, QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = queryCustomizer;
        this.fieldsContext = new FieldsContext(new String[] { field }, queryContext);
    }

    public ConnectedSimpleQueryStringMatchingContext(String[] fields, QueryCustomizer queryCustomizer, QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = queryCustomizer;
        this.fieldsContext = new FieldsContext(fields, queryContext);
    }

    @Override
    public SimpleQueryStringMatchingContext andField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringMatchingContext andFields(String... fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringMatchingContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringTermination matching(String simpleQueryString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringDefinitionTermination withAndAsDefaultOperator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
