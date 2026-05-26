/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.search.aggregation.dsl.AggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.dsl.TermsAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.query.facet.Facet;

/**
 * A facet request for string based fields.
 *
 * @author Hardy Ferentschik
 */
public class DiscreteFacetRequest extends FacetingRequestImpl<Map<Object, Long>> {

    DiscreteFacetRequest(String name, String fieldName) {
        super(name, fieldName);
    }

    @Override
    public AggregationFinalStep<Map<Object, Long>> requestAggregation(TypedSearchAggregationFactory<?> factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Facet> toFacets(Map<Object, Long> aggregation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class SimpleFacet extends AbstractFacet {

        SimpleFacet(String facetingName, String absoluteFieldPath, String value, int count) {
            super(facetingName, absoluteFieldPath, value, count);
        }
    }
}
