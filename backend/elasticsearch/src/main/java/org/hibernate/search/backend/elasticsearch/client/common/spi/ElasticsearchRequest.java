/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.engine.common.timing.Deadline;
import com.google.gson.JsonObject;

public final class ElasticsearchRequest {

    public static Builder put() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder post() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder delete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder builder(String method) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String method;

    private final String path;

    private final Map<String, String> parameters;

    private final List<JsonObject> bodyParts;

    private final Deadline deadline;

    private ElasticsearchRequest(Builder builder) {
        this.method = builder.method;
        this.path = builder.pathBuilder.toString();
        this.parameters = builder.parameters == null ? Collections.emptyMap() : Collections.unmodifiableMap(builder.parameters);
        this.bodyParts = builder.bodyParts == null ? Collections.emptyList() : Collections.unmodifiableList(builder.bodyParts);
        this.deadline = builder.deadline;
    }

    public String method() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String path() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, String> parameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<JsonObject> bodyParts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Deadline deadline() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder {

        private static final char PATH_SEPARATOR = '/';

        private final String method;

        private final StringBuilder pathBuilder = new StringBuilder(20);

        private Map<String, String> parameters;

        private List<JsonObject> bodyParts;

        private Deadline deadline;

        private Builder(String method) {
            super();
            this.method = method;
        }

        public Builder wholeEncodedPath(String path) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder pathComponent(URLEncodedString pathComponent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder multiValuedPathComponent(Iterable<URLEncodedString> indexNames) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder param(String name, String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder param(String name, int value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder param(String name, long value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder param(String name, boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder multiValuedParam(String name, Collection<String> values) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder body(JsonObject object) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder deadline(Deadline deadline) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ElasticsearchRequest build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
