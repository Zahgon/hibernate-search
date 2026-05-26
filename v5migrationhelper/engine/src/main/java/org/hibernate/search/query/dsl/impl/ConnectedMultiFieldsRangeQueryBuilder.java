/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.engine.search.predicate.dsl.RangePredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.query.dsl.RangeTerminationExcludable;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.data.Range;
import org.hibernate.search.util.common.data.RangeBoundInclusion;

/**
 * @author Emmanuel Bernard
 * @author Sanne Grinovero
 */
public class ConnectedMultiFieldsRangeQueryBuilder extends AbstractConnectedMultiFieldsQueryBuilder<RangeTerminationExcludable, RangePredicateOptionsStep<?>> implements RangeTerminationExcludable {

    private final RangeQueryContext rangeContext;

    public ConnectedMultiFieldsRangeQueryBuilder(QueryBuildingContext queryContext, QueryCustomizer queryCustomizer, FieldsContext fieldsContext, RangeQueryContext rangeContext) {
        super(queryContext, queryCustomizer, fieldsContext);
        this.rangeContext = rangeContext;
    }

    @Override
    public RangeTerminationExcludable excludeLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected RangePredicateOptionsStep<?> createPredicate(SearchPredicateFactory factory, FieldContext fieldContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
