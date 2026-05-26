/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.mapping.impl;

import java.util.Optional;
import org.hibernate.search.backend.elasticsearch.document.impl.DocumentMetadataContributor;
import org.hibernate.search.backend.elasticsearch.document.model.dsl.impl.ElasticsearchStringImplicitFieldContributor;
import org.hibernate.search.backend.elasticsearch.document.model.dsl.impl.IndexSchemaRootContributor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.MetadataFields;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractionHelper;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.engine.backend.document.model.dsl.spi.ImplicitFieldContributor;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Rely on a discriminator field added to each document to resolve the type name.
 * Works correctly with index aliases.
 */
public class DiscriminatorTypeNameMapping implements TypeNameMapping {

    private static final String MAPPED_TYPE_FIELD_NAME = MetadataFields.internalFieldName("entity_type");

    private final TypeNameDiscriminatorSchemaRootContributor schemaRootContributor = new TypeNameDiscriminatorSchemaRootContributor();

    private final TypeNameFromDiscriminatorExtractionHelper typeNameExtractionHelper = new TypeNameFromDiscriminatorExtractionHelper();

    @Override
    public Optional<IndexSchemaRootContributor> getIndexSchemaRootContributor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<DocumentMetadataContributor> getDocumentMetadataContributor(String mappedTypeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<ImplicitFieldContributor> getImplicitFieldContributor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionExtractionHelper<String> onStart(IndexLayoutStrategy indexLayoutStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void register(IndexNames indexNames, String mappedTypeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class TypeNameDiscriminatorSchemaRootContributor implements IndexSchemaRootContributor {

        @Override
        public void contribute(RootTypeMapping rootTypeMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class TypeNameDiscriminatorContributor implements DocumentMetadataContributor {

        private static final JsonAccessor<String> DOCUMENT_MAPPED_TYPE_FIELD_ACCESSOR = JsonAccessor.root().property(MAPPED_TYPE_FIELD_NAME).asString();

        private final String mappedTypeName;

        private TypeNameDiscriminatorContributor(String mappedTypeName) {
            this.mappedTypeName = mappedTypeName;
        }

        @Override
        public void contribute(JsonObject document, String tenantId, String id) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class TypeNameFromDiscriminatorExtractionHelper implements ProjectionExtractionHelper<String> {

        private static final JsonAccessor<String> HIT_MAPPED_TYPE_NAME_ACCESSOR = JsonAccessor.root().property("fields").asObject().property(MAPPED_TYPE_FIELD_NAME).asArray().element(0).asString();

        private static final JsonPrimitive MAPPED_TYPE_FIELD_NAME_JSON = new JsonPrimitive(MAPPED_TYPE_FIELD_NAME);

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
