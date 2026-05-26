/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.engine.search.predicate.dsl.MatchPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.query.dsl.TermTermination;

/**
 * @author Emmanuel Bernard
 */
public class ConnectedMultiFieldsMatchQueryBuilder extends AbstractConnectedMultiFieldsQueryBuilder<TermTermination, MatchPredicateOptionsStep<?>> implements TermTermination {

    private final Object value;

    private final TermQueryContext termContext;

    public ConnectedMultiFieldsMatchQueryBuilder(QueryBuildingContext queryContext, QueryCustomizer queryCustomizer, FieldsContext fieldsContext, Object value, TermQueryContext termContext) {
        super(queryContext, queryCustomizer, fieldsContext);
        this.value = value;
        this.termContext = termContext;
    }

    @Override
    protected MatchPredicateOptionsStep<?> createPredicate(SearchPredicateFactory factory, FieldContext fieldContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
