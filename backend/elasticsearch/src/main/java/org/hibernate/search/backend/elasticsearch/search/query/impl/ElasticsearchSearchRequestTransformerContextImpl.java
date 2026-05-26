/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.query.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchRequestTransformer;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchRequestTransformerContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Contracts;
import com.google.gson.JsonObject;

final class ElasticsearchSearchRequestTransformerContextImpl implements ElasticsearchSearchRequestTransformerContext {

    static Function<ElasticsearchRequest, ElasticsearchRequest> createTransformerFunction(ElasticsearchSearchRequestTransformer transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final ElasticsearchRequest originalRequest;

    private final JsonObject originalBody;

    private String path;

    private JsonObject potentiallyTransformedBody;

    private Map<String, String> potentiallyTransformedParametersMap;

    private ElasticsearchSearchRequestTransformerContextImpl(ElasticsearchRequest originalRequest) {
        this.originalRequest = originalRequest;
        List<JsonObject> originalBodyParts = originalRequest.bodyParts();
        if (originalBodyParts.size() != 1) {
            throw new AssertionFailure("Request transformation was applied to a request with no body part or more than one body parts.");
        }
        this.originalBody = originalBodyParts.get(0);
        this.path = originalRequest.path();
    }

    @Override
    public String path() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void path(String newPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, String> parametersMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject body() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchRequest apply(ElasticsearchSearchRequestTransformer transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
