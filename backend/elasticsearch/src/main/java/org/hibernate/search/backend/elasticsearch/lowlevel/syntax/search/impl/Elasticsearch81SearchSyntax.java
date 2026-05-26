/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.syntax.search.impl;

import java.util.List;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonArrayAccessor;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * The search syntax for ES8.1 and later.
 */
public class Elasticsearch81SearchSyntax implements ElasticsearchSearchSyntax {

    private static final JsonArrayAccessor DOCVALUE_FIELDS_ACCESSOR = JsonAccessor.root().property("docvalue_fields").asArray();

    private static final JsonAccessor<JsonElement> NESTED_ACCESSOR = JsonAccessor.root().property("nested");

    private static final JsonAccessor<JsonElement> PATH_ACCESSOR = JsonAccessor.root().property("path");

    private static final JsonAccessor<JsonElement> FILTER_ACCESSOR = JsonAccessor.root().property("filter");

    private static final JsonAccessor<Boolean> IGNORE_UNMAPPED_ACCESSOR = JsonAccessor.root().property("ignore_unmapped").asBoolean();

    @Override
    public String getTermAggregationOrderByTermToken() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void requestDocValues(JsonObject requestBody, JsonPrimitive fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void requestNestedSort(List<String> nestedPathHierarchy, JsonObject innerObject, JsonObject filterOrNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void requestGeoDistanceSortIgnoreUnmapped(JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonElement encodeLongForAggregation(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
