/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.search.query.facet.FacetSortOrder;
import org.hibernate.search.query.facet.FacetingRequest;
import org.hibernate.search.util.StringHelper;
import org.hibernate.search.util.common.data.Range;
import org.hibernate.search.util.common.data.RangeBoundInclusion;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;

/**
 * @author Hardy Ferentschik
 */
class FacetBuildingContext<T> {

    private static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    /**
     * The list of types which are supported for range faceting
     */
    private static final List<String> allowedRangeTypes = Arrays.asList(String.class.getName(), Integer.class.getName(), Long.class.getName(), Double.class.getName(), Float.class.getName(), Date.class.getName());

    private final QueryBuildingContext context;

    private String name;

    private String fieldName;

    private FacetSortOrder sort = FacetSortOrder.COUNT_DESC;

    private boolean includeZeroCount = false;

    private boolean isRangeQuery = false;

    private List<FacetRange<T>> rangeList = new ArrayList<>();

    private T rangeStart;

    private boolean includeRangeStart = true;

    private T rangeEnd;

    private boolean includeRangeEnd = true;

    private int maxFacetCount = -1;

    public FacetBuildingContext(QueryBuildingContext context) {
        this.context = context;
    }

    void setName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void setFieldName(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void setSort(FacetSortOrder sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void setIncludeZeroCount(boolean includeZeroCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRangeQuery(boolean rangeQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRangeStart(T rangeStart) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIncludeRangeStart(boolean includeRangeStart) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRangeEnd(T rangeEnd) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIncludeRangeEnd(boolean includeRangeEnd) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxFacetCount(int maxFacetCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void makeRange() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void assertValidRangeType(Class<?> clazz) {
        if (!allowedRangeTypes.contains(clazz.getName())) {
            throw log.unsupportedParameterTypeForRangeFaceting(clazz.getName(), StringHelper.join(allowedRangeTypes, ","));
        }
    }

    private Class<?> getRangeType() {
        if (rangeStart == null && rangeEnd == null) {
            throw log.noStartOrEndSpecifiedForRangeQuery(name);
        }
        T tmp = rangeStart;
        if (tmp == null) {
            tmp = rangeEnd;
        }
        return tmp.getClass();
    }

    FacetingRequest getFacetingRequest() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
