/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.dsl.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.hibernate.search.backend.elasticsearch.analysis.model.impl.ElasticsearchAnalysisDefinitionRegistry;
import org.hibernate.search.backend.elasticsearch.document.model.impl.AbstractElasticsearchIndexFieldTemplate;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexModel;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexObjectField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexObjectFieldTemplate;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexRoot;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexValueField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexValueFieldTemplate;
import org.hibernate.search.backend.elasticsearch.index.DynamicMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicType;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.NamedDynamicTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RoutingType;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.PropertyMappingIndexSettingsContributor;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchCountDocumentAggregation;
import org.hibernate.search.backend.elasticsearch.types.dsl.ElasticsearchIndexFieldTypeFactory;
import org.hibernate.search.backend.elasticsearch.types.dsl.provider.impl.ElasticsearchIndexFieldTypeFactoryProvider;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexCompositeNodeType;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.backend.document.model.dsl.spi.ImplicitFieldCollector;
import org.hibernate.search.engine.backend.document.model.dsl.spi.ImplicitFieldContributor;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexRootBuilder;
import org.hibernate.search.engine.backend.document.model.spi.IndexIdentifier;
import org.hibernate.search.engine.backend.mapping.spi.BackendMapperContext;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexFieldTypeDefaultsProvider;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.util.common.reporting.EventContext;

public class ElasticsearchIndexRootBuilder extends AbstractElasticsearchIndexCompositeNodeBuilder implements IndexRootBuilder {

    private final ElasticsearchIndexFieldTypeFactoryProvider typeFactoryProvider;

    private final EventContext indexEventContext;

    private final BackendMapperContext backendMapperContext;

    private final List<IndexSchemaRootContributor> schemaRootContributors = new ArrayList<>();

    private final List<ImplicitFieldContributor> implicitFieldContributors = new ArrayList<>();

    private final String hibernateSearchIndexName;

    private final String mappedTypeName;

    private final ElasticsearchAnalysisDefinitionRegistry analysisDefinitionRegistry;

    private final IndexSettings customIndexSettings;

    private final RootTypeMapping customIndexMapping;

    private final DynamicType defaultDynamicType;

    private RoutingType routing = null;

    private DslConverter<?, String> idDslConverter;

    private DslConverter<String, String> idParser;

    private ProjectionConverter<String, ?> idProjectionConverter;

    public ElasticsearchIndexRootBuilder(ElasticsearchIndexFieldTypeFactoryProvider typeFactoryProvider, EventContext indexEventContext, BackendMapperContext backendMapperContext, String hibernateSearchIndexName, String mappedTypeName, ElasticsearchAnalysisDefinitionRegistry analysisDefinitionRegistry, IndexSettings customIndexSettings, RootTypeMapping customIndexMapping, DynamicMapping dynamicMapping) {
        super(new ElasticsearchIndexCompositeNodeType.Builder(ObjectStructure.FLATTENED));
        this.typeFactoryProvider = typeFactoryProvider;
        this.indexEventContext = indexEventContext;
        this.backendMapperContext = backendMapperContext;
        this.hibernateSearchIndexName = hibernateSearchIndexName;
        this.mappedTypeName = mappedTypeName;
        this.analysisDefinitionRegistry = analysisDefinitionRegistry;
        this.customIndexSettings = customIndexSettings;
        this.customIndexMapping = customIndexMapping;
        this.defaultDynamicType = DynamicType.create(dynamicMapping);
        this.typeBuilder.queryElementFactory(AggregationTypeKeys.COUNT_DOCUMENTS, ElasticsearchCountDocumentAggregation.factory());
        this.addDefaultImplicitFields();
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexFieldTypeFactory createTypeFactory(IndexFieldTypeDefaultsProvider defaultsProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void explicitRouting() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I> void idDslConverter(Class<I> valueType, ToDocumentValueConverter<I, String> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void idParser(ToDocumentValueConverter<String, String> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I> void idProjectionConverter(Class<I> valueType, FromDocumentValueConverter<String, I> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addSchemaRootContributor(IndexSchemaRootContributor schemaRootContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addImplicitFieldContributor(ImplicitFieldContributor implicitFieldContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchIndexModel build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ElasticsearchIndexRootBuilder getRootNodeBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getAbsolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    EventContext getIndexEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addDefaultImplicitFields() {
        implicitFieldContributors.add(new ElasticsearchStringImplicitFieldContributor("_id"));
        implicitFieldContributors.add(new ElasticsearchStringImplicitFieldContributor("_index"));
    }
}
