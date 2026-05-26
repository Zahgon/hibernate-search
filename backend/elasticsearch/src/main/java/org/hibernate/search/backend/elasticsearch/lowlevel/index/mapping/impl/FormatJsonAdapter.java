/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class FormatJsonAdapter extends TypeAdapter<List<String>> {

    private static final String FORMAT_SEPARATOR_REGEX = "\\|\\|";

    private static final String FORMAT_SEPARATOR = "||";

    @Override
    public void write(JsonWriter out, List<String> value) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> read(JsonReader in) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
