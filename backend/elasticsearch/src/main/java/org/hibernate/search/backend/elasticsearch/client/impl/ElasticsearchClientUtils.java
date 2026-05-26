/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.impl;

import org.hibernate.search.backend.elasticsearch.ElasticsearchDistributionName;
import org.hibernate.search.backend.elasticsearch.ElasticsearchVersion;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchClient;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Futures;

public final class ElasticsearchClientUtils {

    private static final JsonAccessor<String> DISTRIBUTION_ACCESSOR = JsonAccessor.root().property("version").property("distribution").asString();

    private static final JsonAccessor<String> VERSION_ACCESSOR = JsonAccessor.root().property("version").property("number").asString();

    private ElasticsearchClientUtils() {
        // Private constructor
    }

    public static boolean isSuccessCode(int code) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ElasticsearchVersion tryGetElasticsearchVersion(ElasticsearchClient client) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
