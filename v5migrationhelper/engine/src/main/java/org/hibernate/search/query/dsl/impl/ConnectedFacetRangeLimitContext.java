/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.FacetRangeEndContext;
import org.hibernate.search.query.dsl.FacetRangeLimitContext;

/**
 * @author Hardy Ferentschik
 */
public class ConnectedFacetRangeLimitContext<T> implements FacetRangeLimitContext<T> {

    private final FacetBuildingContext context;

    public ConnectedFacetRangeLimitContext(FacetBuildingContext context) {
        this.context = context;
    }

    @Override
    public FacetRangeLimitContext<T> excludeLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FacetRangeEndContext<T> to(T upperLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
