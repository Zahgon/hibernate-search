/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.FacetContinuationContext;
import org.hibernate.search.query.dsl.FacetFieldContext;

/**
 * @author Hardy Ferentschik
 */
public class ConnectedFacetFieldContext implements FacetFieldContext {

    private final FacetBuildingContext context;

    public ConnectedFacetFieldContext(FacetBuildingContext context) {
        this.context = context;
    }

    @Override
    public FacetContinuationContext onField(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
