/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import java.io.IOException;
import java.util.Map;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public abstract class AbstractExtraPropertiesJsonAdapter<T> extends TypeAdapter<T> {

    interface FieldAdapter<T> {

        void read(JsonReader in, T instance) throws IOException;

        void write(JsonWriter out, T instance) throws IOException;

        boolean serialized();
    }

    interface ExtraPropertyAdapter<T> {

        void readOne(JsonReader in, String name, T instance) throws IOException;

        void writeAll(JsonWriter out, T instance) throws IOException;
    }

    private final Map<String, ? extends FieldAdapter<? super T>> fieldAdapters;

    private final ExtraPropertyAdapter<? super T> extraPropertyAdapter;

    public AbstractExtraPropertiesJsonAdapter(Map<String, ? extends FieldAdapter<? super T>> fieldAdapters, ExtraPropertyAdapter<? super T> extraPropertyAdapter) {
        super();
        this.fieldAdapters = fieldAdapters;
        this.extraPropertyAdapter = extraPropertyAdapter;
    }

    @Override
    public T read(JsonReader in) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(JsonWriter out, T instance) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract T createInstance();
}
