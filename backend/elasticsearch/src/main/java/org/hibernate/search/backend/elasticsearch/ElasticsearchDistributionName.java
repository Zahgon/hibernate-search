/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.search.backend.elasticsearch.logging.spi.ConfigurationLog;
import org.hibernate.search.engine.cfg.spi.ParseUtils;
import org.hibernate.search.util.common.annotation.Incubating;

public enum ElasticsearchDistributionName {

    /**
     * The Elasticsearch distribution from Elastic.
     * <p>
     * See: <a href="https://www.elastic.co/elasticsearch/">https://www.elastic.co/elasticsearch/</a>.
     */
    ELASTIC("elastic", "elastic"),
    /**
     * The OpenSearch distribution from the OpenSearch organization.
     * <p>
     * When used through Amazon OpenSearch Service, requires extra dependencies for authentication;
     * refer to the reference documentation.
     * <p>
     * See: <a href="https://www.opensearch.org/">https://www.opensearch.org/</a>.
     */
    OPENSEARCH("opensearch", "opensearch"),
    /**
     * Amazon OpenSearch Serverless.
     * <p>
     * Requires extra dependencies for authentication;
     * refer to the reference documentation.
     * <p>
     * See: <a href="https://docs.aws.amazon.com/opensearch-service/latest/developerguide/serverless-overview.html">https://docs.aws.amazon.com/opensearch-service/latest/developerguide/serverless-overview.html</a>.
     */
    @Incubating
    AMAZON_OPENSEARCH_SERVERLESS("amazon-opensearch-serverless", null);

    // This method conforms to the MicroProfile Config specification. Do not change its signature.
    public static ElasticsearchDistributionName of(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static List<String> allowedExternalRepresentations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ElasticsearchDistributionName fromServerResponseRepresentation(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static ElasticsearchDistributionName defaultValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String externalRepresentation;

    private final String serverResponseRepresentation;

    ElasticsearchDistributionName(String externalRepresentation, String serverResponseRepresentation) {
        this.externalRepresentation = externalRepresentation;
        this.serverResponseRepresentation = serverResponseRepresentation;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The expected string representation in configuration properties.
     */
    public String externalRepresentation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    String serverResponseRepresentation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
