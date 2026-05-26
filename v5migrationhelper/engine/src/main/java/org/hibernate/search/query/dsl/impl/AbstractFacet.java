/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.facet.Facet;

/**
 * A single facet (field value and count).
 *
 * @author Hardy Ferentschik
 */
public abstract class AbstractFacet implements Facet {

    private final String facetingName;

    private final String absoluteFieldPath;

    private final String value;

    private final int count;

    public AbstractFacet(String facetingName, String absoluteFieldPath, String value, int count) {
        this.facetingName = facetingName;
        this.absoluteFieldPath = absoluteFieldPath;
        this.count = count;
        this.value = value;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getFacetingName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
