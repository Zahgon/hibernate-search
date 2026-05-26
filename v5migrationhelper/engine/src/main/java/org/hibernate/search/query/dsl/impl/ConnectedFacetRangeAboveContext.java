/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.FacetRangeAboveContext;
import org.hibernate.search.query.facet.FacetingRequest;

/**
 * @author Hardy Ferentschik
 */
public class ConnectedFacetRangeAboveContext<T> extends ConnectedFacetParameterContext implements FacetRangeAboveContext<T> {

    private final FacetBuildingContext context;

    public ConnectedFacetRangeAboveContext(FacetBuildingContext context) {
        super(context);
        this.context = context;
    }

    @Override
    public FacetRangeAboveContext<T> excludeLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetingRequest createFacetingRequest() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
