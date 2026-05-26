/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.spi;

import com.google.gson.JsonObject;

public final class ElasticsearchResponse {

    private final String hostAndPort;

    private final int statusCode;

    private final String statusMessage;

    private final JsonObject body;

    public ElasticsearchResponse(String hostAndPort, int statusCode, String statusMessage, JsonObject body) {
        this.hostAndPort = hostAndPort;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
    }

    public String hostAndPort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int statusCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String statusMessage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public JsonObject body() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
