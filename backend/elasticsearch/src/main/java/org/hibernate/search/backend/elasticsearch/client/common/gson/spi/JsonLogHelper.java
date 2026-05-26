/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.gson.spi;

import java.io.PrintWriter;
import java.io.StringWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Helpers allowing to log JSON.
 */
public final class JsonLogHelper {

    private static final JsonLogHelper INSTANCE = create(new GsonBuilder(), true);

    public static JsonLogHelper get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JsonLogHelper create(GsonBuilder gsonBuilder, boolean prettyPrinting) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Gson gson;

    private final boolean prettyPrinting;

    private JsonLogHelper(Gson gson, boolean prettyPrinting) {
        this.gson = gson;
        this.prettyPrinting = prettyPrinting;
    }

    public String toString(JsonObject object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void append(StringBuilder sb, JsonObject object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toString(Iterable<JsonObject> objects) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void append(StringBuilder sb, Iterable<JsonObject> objects) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void beforeValue(StringBuilder sb) {
        if (prettyPrinting) {
            sb.append("\n");
        }
    }

    private void doAppend(StringBuilder sb, JsonObject object) {
        try {
            gson.toJson(object, sb);
        } catch (RuntimeException e) {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            sb.append(writer.toString());
        }
    }

    private void afterValue(StringBuilder sb) {
        if (prettyPrinting) {
            sb.append("\n");
        }
    }
}
