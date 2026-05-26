/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.impl;

import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.analysis.model.impl.ElasticsearchAnalysisDefinitionRegistry;
import org.hibernate.search.backend.elasticsearch.document.model.lowlevel.impl.LowLevelIndexMetadataBuilder;
import org.hibernate.search.backend.elasticsearch.index.impl.IndexManagerBackendContext;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.PropertyMappingIndexSettingsContributor;
import org.hibernate.search.backend.elasticsearch.metamodel.ElasticsearchIndexDescriptor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexContext;
import org.hibernate.search.engine.backend.document.model.spi.AbstractIndexModel;
import org.hibernate.search.engine.backend.document.model.spi.IndexIdentifier;

public class ElasticsearchIndexModel extends AbstractIndexModel<ElasticsearchIndexModel, ElasticsearchIndexRoot, ElasticsearchIndexField> implements ElasticsearchIndexDescriptor, ElasticsearchSearchIndexContext {

    private final String hibernateSearchIndexName;

    private final ElasticsearchAnalysisDefinitionRegistry analysisDefinitionRegistry;

    private final PropertyMappingIndexSettingsContributor propertyMappingIndexSettingsContributor;

    private final IndexSettings customIndexSettings;

    private final RootTypeMapping mapping;

    private final RootTypeMapping customMapping;

    private IndexNames names;

    public ElasticsearchIndexModel(String hibernateSearchIndexName, String mappedTypeName, IndexIdentifier identifier, ElasticsearchIndexRoot rootNode, Map<String, ElasticsearchIndexField> staticFields, List<AbstractElasticsearchIndexFieldTemplate<?>> fieldTemplates, ElasticsearchAnalysisDefinitionRegistry analysisDefinitionRegistry, PropertyMappingIndexSettingsContributor propertyMappingIndexSettingsContributor, IndexSettings customIndexSettings, RootTypeMapping mapping, RootTypeMapping customMapping) {
        super(analysisDefinitionRegistry, hibernateSearchIndexName, mappedTypeName, identifier, rootNode, staticFields, fieldTemplates);
        this.hibernateSearchIndexName = hibernateSearchIndexName;
        this.analysisDefinitionRegistry = analysisDefinitionRegistry;
        this.propertyMappingIndexSettingsContributor = propertyMappingIndexSettingsContributor;
        this.customIndexSettings = customIndexSettings;
        this.mapping = mapping;
        this.customMapping = customMapping;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchIndexModel self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexNames names() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int maxResultWindow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeLowLevelMetadata(LowLevelIndexMetadataBuilder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String readName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String writeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String hibernateSearchIndexName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void onStart(IndexManagerBackendContext backendContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
