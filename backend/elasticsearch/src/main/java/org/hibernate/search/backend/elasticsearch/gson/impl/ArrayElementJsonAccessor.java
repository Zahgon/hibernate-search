/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;

class ArrayElementJsonAccessor extends AbstractCrawlingJsonAccessor<JsonArray> {

    private final int index;

    public ArrayElementJsonAccessor(JsonCompositeAccessor<JsonArray> parentAccessor, int index) {
        super(parentAccessor);
        this.index = index;
    }

    @Override
    protected JsonElement doGet(JsonArray parent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doSet(JsonArray parent, JsonElement newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void fillTo(JsonArray array, int index) {
        for (int i = array.size(); i <= index; ++i) {
            array.add(JsonNull.INSTANCE);
        }
    }

    @Override
    protected void appendRuntimeRelativePath(StringBuilder path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void appendStaticRelativePath(StringBuilder path, boolean first) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
