/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.AllContext;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.FacetContext;
import org.hibernate.search.query.dsl.PhraseContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.RangeContext;
import org.hibernate.search.query.dsl.SimpleQueryStringContext;
import org.hibernate.search.query.dsl.SpatialContext;
import org.hibernate.search.query.dsl.TermContext;
import org.hibernate.search.query.dsl.sort.SortContext;
import org.hibernate.search.query.dsl.sort.impl.ConnectedSortContext;

/**
 * Assuming connection with the search factory
 *
 * @author Emmanuel Bernard
 */
public class ConnectedQueryBuilder implements QueryBuilder {

    private final QueryBuildingContext context;

    public ConnectedQueryBuilder(QueryBuildingContext context) {
        this.context = context;
    }

    @Override
    public TermContext keyword() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeContext range() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PhraseContext phrase() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringContext simpleQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    //fixme Have to use raw types but would be nice to not have to
    @Override
    public BooleanJunction bool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AllContext all() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetContext facet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialContext spatial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortContext sort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
