/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.sort.impl;

import org.hibernate.search.query.dsl.impl.QueryBuildingContext;
import org.hibernate.search.query.dsl.sort.SortFieldContext;
import org.hibernate.search.query.dsl.sort.SortMissingValueContext;
import org.apache.lucene.search.Sort;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
public class ConnectedSortFieldContext extends ConnectedSortAdditionalSortFieldContext implements SortFieldContext, SortMissingValueContext<SortFieldContext> {

    public ConnectedSortFieldContext(QueryBuildingContext queryContext, SortFieldStates states) {
        super(queryContext, states);
    }

    @Override
    public SortFieldContext asc() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortFieldContext desc() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Sort createSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortMissingValueContext<SortFieldContext> onMissingValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortFieldContext sortLast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortFieldContext sortFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortFieldContext use(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
