/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.model.dsl.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.document.model.impl.AbstractLuceneIndexFieldTemplate;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexObjectField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexObjectFieldTemplate;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexRoot;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexValueField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexValueFieldTemplate;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LuceneCountDocumentAggregation;
import org.hibernate.search.backend.lucene.types.dsl.LuceneIndexFieldTypeFactory;
import org.hibernate.search.backend.lucene.types.dsl.impl.LuceneIndexFieldTypeFactoryImpl;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexCompositeNodeType;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexRootBuilder;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexSchemaBuildContext;
import org.hibernate.search.engine.backend.document.model.spi.IndexIdentifier;
import org.hibernate.search.engine.backend.mapping.spi.BackendMapperContext;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexFieldTypeDefaultsProvider;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.util.common.reporting.EventContext;

public class LuceneIndexRootBuilder extends AbstractLuceneIndexCompositeNodeBuilder implements IndexRootBuilder, IndexSchemaBuildContext {

    private final EventContext indexEventContext;

    private final BackendMapperContext backendMapperContext;

    private final String mappedTypeName;

    private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

    private DslConverter<?, String> idDslConverter;

    private DslConverter<?, String> idParser;

    private ProjectionConverter<String, ?> idProjectionConverter;

    public LuceneIndexRootBuilder(EventContext indexEventContext, BackendMapperContext backendMapperContext, String mappedTypeName, LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry) {
        super(new LuceneIndexCompositeNodeType.Builder(ObjectStructure.FLATTENED));
        this.indexEventContext = indexEventContext;
        this.backendMapperContext = backendMapperContext;
        this.mappedTypeName = mappedTypeName;
        this.analysisDefinitionRegistry = analysisDefinitionRegistry;
        this.typeBuilder.queryElementFactory(AggregationTypeKeys.COUNT_DOCUMENTS, LuceneCountDocumentAggregation.factory());
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexFieldTypeFactory createTypeFactory(IndexFieldTypeDefaultsProvider defaultsProvider) {
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

    @Override
    public LuceneIndexRootBuilder getRootNodeBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LuceneIndexModel build(String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getAbsolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    EventContext getIndexEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
