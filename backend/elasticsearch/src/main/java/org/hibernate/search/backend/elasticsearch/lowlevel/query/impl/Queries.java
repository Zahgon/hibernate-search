/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.query.impl;

import java.util.Collection;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public final class Queries {

    private Queries() {
    }

    public static JsonObject matchAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JsonObject term(String absoluteFieldPath, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JsonObject anyTerm(String absoluteFieldPath, Collection<String> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JsonObject boolFilter(JsonObject must, JsonArray filters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JsonObject boolCombineMust(JsonObject must, JsonArray otherMustClauses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
