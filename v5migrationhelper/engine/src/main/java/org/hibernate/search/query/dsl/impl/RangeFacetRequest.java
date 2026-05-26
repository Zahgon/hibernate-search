/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.search.aggregation.dsl.AggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.dsl.RangeAggregationRangeMoreStep;
import org.hibernate.search.engine.search.aggregation.dsl.RangeAggregationRangeStep;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.query.engine.impl.FacetComparators;
import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.FacetSortOrder;
import org.hibernate.search.util.common.data.Range;

/**
 * @author Hardy Ferentschik
 */
public class RangeFacetRequest<T> extends FacetingRequestImpl<Map<Range<T>, Long>> {

    private final List<FacetRange<T>> facetRangeList;

    RangeFacetRequest(String name, String fieldName, List<FacetRange<T>> facetRanges) {
        super(name, fieldName);
        if (facetRanges == null || facetRanges.isEmpty()) {
            throw new IllegalArgumentException("At least one facet range must be specified");
        }
        this.facetRangeList = facetRanges;
    }

    @Override
    public AggregationFinalStep<Map<Range<T>, Long>> requestAggregation(TypedSearchAggregationFactory<?> factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Facet> toFacets(Map<Range<T>, Long> aggregation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Class<T> getFacetValueType() {
        // safe since we have at least one facet range set
        T o = facetRangeList.get(0).getMin();
        if (o == null) {
            o = facetRangeList.get(0).getMax();
        }
        return (Class<T>) o.getClass();
    }

    private int findFacetRangeIndex(Range<T> range) {
        int index = 0;
        for (FacetRange<T> facetRange : facetRangeList) {
            if (facetRange.range().equals(range)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
