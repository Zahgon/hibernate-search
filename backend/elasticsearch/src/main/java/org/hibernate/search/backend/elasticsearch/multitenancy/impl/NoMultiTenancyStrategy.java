/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.multitenancy.impl;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.common.impl.DocumentIdHelper;
import org.hibernate.search.backend.elasticsearch.document.impl.DocumentMetadataContributor;
import org.hibernate.search.backend.elasticsearch.document.model.dsl.impl.IndexSchemaRootContributor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.spi.ConfigurationLog;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractionHelper;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.util.common.reporting.EventContext;
import com.google.gson.JsonObject;

public class NoMultiTenancyStrategy implements MultiTenancyStrategy {

    private final NoMultiTenancyElasticsearchDocumentIdHelper documentIdHelper = new NoMultiTenancyElasticsearchDocumentIdHelper();

    private final NoMultiTenancyIdProjectionExtractionHelper idProjectionExtractionHelper = new NoMultiTenancyIdProjectionExtractionHelper();

    @Override
    public Optional<IndexSchemaRootContributor> indexSchemaRootContributor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentIdHelper documentIdHelper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<DocumentMetadataContributor> documentMetadataContributor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject filterOrNull(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject filterOrNull(Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NoMultiTenancyIdProjectionExtractionHelper idProjectionExtractionHelper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class NoMultiTenancyElasticsearchDocumentIdHelper implements DocumentIdHelper {

        @Override
        public void checkTenantId(String tenantId, EventContext backendContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void checkTenantId(Set<String> tenantIds, EventContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toElasticsearchId(String tenantId, String id) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class NoMultiTenancyIdProjectionExtractionHelper implements ProjectionExtractionHelper<String> {

        private static final JsonAccessor<String> HIT_ID_ACCESSOR = JsonAccessor.root().property("_id").asString();

        @Override
        public void request(JsonObject requestBody, ProjectionRequestContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String extract(JsonObject hit, ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
