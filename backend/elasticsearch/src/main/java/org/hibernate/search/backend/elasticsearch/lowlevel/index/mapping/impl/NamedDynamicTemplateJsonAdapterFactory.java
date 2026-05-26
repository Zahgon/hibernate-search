/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class NamedDynamicTemplateJsonAdapterFactory implements TypeAdapterFactory {

    private static final TypeToken<NamedDynamicTemplate> NAMED_DYNAMIC_TEMPLATE_TYPE_TOKEN = TypeToken.get(NamedDynamicTemplate.class);

    private static final TypeToken<DynamicTemplate> DYNAMIC_TEMPLATE_TYPE_TOKEN = TypeToken.get(DynamicTemplate.class);

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Adapter extends TypeAdapter<NamedDynamicTemplate> {

        private final TypeAdapter<DynamicTemplate> templateAdapter;

        public Adapter(TypeAdapter<DynamicTemplate> templateAdapter) {
            this.templateAdapter = templateAdapter;
        }

        @Override
        public void write(JsonWriter out, NamedDynamicTemplate value) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public NamedDynamicTemplate read(JsonReader in) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
