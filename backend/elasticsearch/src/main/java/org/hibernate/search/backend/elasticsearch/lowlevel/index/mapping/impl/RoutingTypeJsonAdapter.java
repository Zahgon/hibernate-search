/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import java.io.IOException;
import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class RoutingTypeJsonAdapter extends TypeAdapter<RoutingType> {

    @Override
    public void write(JsonWriter out, RoutingType value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RoutingType read(JsonReader in) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
