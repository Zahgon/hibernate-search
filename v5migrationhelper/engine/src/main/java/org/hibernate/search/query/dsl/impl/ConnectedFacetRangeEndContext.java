/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.FacetRangeAboveContext;
import org.hibernate.search.query.dsl.FacetRangeEndContext;
import org.hibernate.search.query.dsl.FacetRangeLimitContext;
import org.hibernate.search.query.facet.FacetingRequest;

/**
 * @author Hardy Ferentschik
 */
public class ConnectedFacetRangeEndContext<T> extends ConnectedFacetParameterContext implements FacetRangeEndContext<T> {

    private final FacetBuildingContext context;

    public ConnectedFacetRangeEndContext(FacetBuildingContext context) {
        super(context);
        this.context = context;
    }

    @Override
    public FacetRangeEndContext<T> excludeLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetRangeAboveContext<T> above(T max) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetRangeLimitContext<T> from(T rangeStart) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetingRequest createFacetingRequest() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
