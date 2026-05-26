/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Encapsulate the common field context state capture.
 *
 * @author Emmanuel Bernard
 */
public class FieldsContext implements Iterable<FieldContext> {

    public static final String[] NO_FIELD = new String[0];

    private final QueryBuildingContext queryContext;

    private final List<FieldContext> fieldContexts;

    //when a varargs of fields are passed, apply the same customization for all.
    //keep the index of the first context in this queue
    private int firstOfContext;

    public FieldsContext(String[] fieldNames, QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        firstOfContext = 0;
        if (fieldNames == null) {
            fieldNames = NO_FIELD;
        }
        fieldContexts = new ArrayList<FieldContext>(fieldNames.length < 4 ? 4 : fieldNames.length);
        for (String fieldName : fieldNames) {
            doAdd(fieldName);
        }
    }

    public void add(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void doAdd(String fieldName) {
        fieldContexts.add(new FieldContext(fieldName));
    }

    public void addAll(String... fieldNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void ignoreAnalyzer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void ignoreFieldBridge() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<FieldContext> getCurrentFieldContexts() {
        return fieldContexts.subList(firstOfContext, fieldContexts.size());
    }

    public FieldContext getFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Iterator<FieldContext> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
