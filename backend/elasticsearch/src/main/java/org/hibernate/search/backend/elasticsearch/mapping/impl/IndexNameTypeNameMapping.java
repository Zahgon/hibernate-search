/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.mapping.impl;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.hibernate.search.backend.elasticsearch.document.impl.DocumentMetadataContributor;
import org.hibernate.search.backend.elasticsearch.document.model.dsl.impl.IndexSchemaRootContributor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractionHelper;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.engine.backend.document.model.dsl.spi.ImplicitFieldContributor;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;
import com.google.gson.JsonObject;

/**
 * Rely on the "_index" meta-field to resolve the type name.
 * Does not work with index aliases.
 */
public class IndexNameTypeNameMapping implements TypeNameMapping {

    private TypeNameFromIndexNameExtractionHelper mappedTypeNameExtractionHelper;

    private IndexLayoutStrategy indexLayoutStrategy;

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

    private static final class TypeNameFromIndexNameExtractionHelper implements ProjectionExtractionHelper<String> {

        private static final JsonAccessor<String> HIT_INDEX_NAME_ACCESSOR = JsonAccessor.root().property("_index").asString();

        private final IndexLayoutStrategy indexLayoutStrategy;

        private final Map<String, String> primaryIndexNameUniqueKeyToMappedTypeNames = new ConcurrentHashMap<>();

        public TypeNameFromIndexNameExtractionHelper(IndexLayoutStrategy indexLayoutStrategy) {
            this.indexLayoutStrategy = indexLayoutStrategy;
        }

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
