/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.multitenancy.impl;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import org.hibernate.search.backend.elasticsearch.common.impl.DocumentIdHelper;
import org.hibernate.search.backend.elasticsearch.document.impl.DocumentMetadataContributor;
import org.hibernate.search.backend.elasticsearch.document.model.dsl.impl.IndexSchemaRootContributor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.spi.ConfigurationLog;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.MetadataFields;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractionHelper;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.util.common.reporting.EventContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class DiscriminatorMultiTenancyStrategy implements MultiTenancyStrategy {

    private static final String ID_FIELD_NAME = MetadataFields.internalFieldName("tenant_doc_id");

    private static final String TENANT_ID_FIELD_NAME = MetadataFields.internalFieldName("tenant_id");

    private final DiscriminatorMultiTenancyIndexSchemaRootContributor schemaRootContributor = new DiscriminatorMultiTenancyIndexSchemaRootContributor();

    private final DiscriminatorMultiTenancyElasticsearchDocumentIdHelper documentIdHelper = new DiscriminatorMultiTenancyElasticsearchDocumentIdHelper();

    private final DiscriminatorMultiTenancyDocumentMetadataContributor documentMetadataContributor = new DiscriminatorMultiTenancyDocumentMetadataContributor();

    private final DiscriminatorMultiTenancyIdProjectionExtractionHelper idProjectionExtractionHelper = new DiscriminatorMultiTenancyIdProjectionExtractionHelper();

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
    public DiscriminatorMultiTenancyIdProjectionExtractionHelper idProjectionExtractionHelper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class DiscriminatorMultiTenancyIndexSchemaRootContributor implements IndexSchemaRootContributor {

        @Override
        public void contribute(RootTypeMapping rootTypeMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class DiscriminatorMultiTenancyElasticsearchDocumentIdHelper implements DocumentIdHelper {

        private static final Pattern UNDERSCORE_PATTERN = Pattern.compile("_");

        private static final String ESCAPED_UNDERSCORE = "__";

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

    private static class DiscriminatorMultiTenancyDocumentMetadataContributor implements DocumentMetadataContributor {

        private static final JsonAccessor<String> TENANT_ID_ACCESSOR = JsonAccessor.root().property(TENANT_ID_FIELD_NAME).asString();

        private static final JsonAccessor<String> ID_ACCESSOR = JsonAccessor.root().property(ID_FIELD_NAME).asString();

        @Override
        public void contribute(JsonObject document, String tenantId, String id) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class DiscriminatorMultiTenancyIdProjectionExtractionHelper implements ProjectionExtractionHelper<String> {

        private static final JsonAccessor<String> HIT_ID_ACCESSOR = JsonAccessor.root().property("fields").asObject().property(ID_FIELD_NAME).asArray().element(0).asString();

        private static final JsonPrimitive ID_FIELD_NAME_JSON = new JsonPrimitive(ID_FIELD_NAME);

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
