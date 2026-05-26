/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.engine.impl;

import java.io.Serializable;
import java.util.Comparator;
import java.util.EnumMap;
import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.FacetSortOrder;

public class FacetComparators {

    private static final EnumMap<FacetSortOrder, FacetComparator> FACET_COMPARATORS = new EnumMap<>(FacetSortOrder.class);

    static {
        FACET_COMPARATORS.put(FacetSortOrder.COUNT_ASC, new FacetComparator(FacetSortOrder.COUNT_ASC));
        FACET_COMPARATORS.put(FacetSortOrder.COUNT_DESC, new FacetComparator(FacetSortOrder.COUNT_DESC));
        FACET_COMPARATORS.put(FacetSortOrder.FIELD_VALUE, new FacetComparator(FacetSortOrder.FIELD_VALUE));
    }

    private FacetComparators() {
    }

    public static FacetComparator get(FacetSortOrder facetSortOrder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class FacetComparator implements Comparator<Facet>, Serializable {

        private final FacetSortOrder sortOder;

        public FacetComparator(FacetSortOrder sortOrder) {
            this.sortOder = sortOrder;
        }

        @Override
        public int compare(Facet facet1, Facet facet2) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
