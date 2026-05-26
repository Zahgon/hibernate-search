/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.dsl.impl;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexCompositeNode;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexField;
import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.AbstractTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicType;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchNamedPredicate;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexCompositeNodeType;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldTemplateOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaNamedPredicateOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexCompositeNodeBuilder;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexObjectFieldBuilder;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.search.predicate.definition.PredicateDefinition;
import org.hibernate.search.engine.search.predicate.definition.TypedPredicateDefinition;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;

public abstract class AbstractElasticsearchIndexCompositeNodeBuilder implements IndexCompositeNodeBuilder {

    protected final ElasticsearchIndexCompositeNodeType.Builder typeBuilder;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<String, ElasticsearchIndexNodeContributor> fields = new LinkedHashMap<>();

    private final Map<String, ElasticsearchIndexNodeContributor> templates = new LinkedHashMap<>();

    private final Set<String> namedPredicates = new LinkedHashSet<>();

    protected AbstractElasticsearchIndexCompositeNodeBuilder(ElasticsearchIndexCompositeNodeType.Builder typeBuilder) {
        this.typeBuilder = typeBuilder;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <F> IndexSchemaFieldOptionsStep<?, IndexFieldReference<F>> addField(String relativeFieldName, TreeNodeInclusion inclusion, IndexFieldType<F> indexFieldType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexObjectFieldBuilder addObjectField(String relativeFieldName, TreeNodeInclusion inclusion, ObjectStructure structure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaNamedPredicateOptionsStep addNamedPredicate(String name, TreeNodeInclusion inclusion, PredicateDefinition definition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaNamedPredicateOptionsStep addNamedPredicate(String name, TreeNodeInclusion inclusion, TypedPredicateDefinition<?> definition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaFieldTemplateOptionsStep<?> addFieldTemplate(String templateName, TreeNodeInclusion inclusion, IndexFieldType<?> indexFieldType, String prefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaFieldTemplateOptionsStep<?> addObjectFieldTemplate(String templateName, ObjectStructure structure, String prefix, TreeNodeInclusion inclusion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final void contributeChildren(AbstractTypeMapping mapping, ElasticsearchIndexCompositeNode node, ElasticsearchIndexNodeCollector collector, Map<String, ElasticsearchIndexField> staticChildrenByNameForParent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract ElasticsearchIndexRootBuilder getRootNodeBuilder();

    abstract String getAbsolutePath();

    final DynamicType resolveSelfDynamicType(DynamicType defaultDynamicType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void putField(String name, ElasticsearchIndexNodeContributor contributor) {
        Object previous = fields.putIfAbsent(name, contributor);
        if (previous != null) {
            throw MappingLog.INSTANCE.indexSchemaNodeNameConflict(name, eventContext());
        }
    }

    private void putTemplate(String name, ElasticsearchIndexNodeContributor contributor) {
        Object previous = templates.putIfAbsent(name, contributor);
        if (previous != null) {
            throw MappingLog.INSTANCE.indexSchemaFieldTemplateNameConflict(name, eventContext());
        }
    }

    private void putNamedPredicate(String name) {
        if (!namedPredicates.add(name)) {
            throw MappingLog.INSTANCE.indexSchemaNamedPredicateNameConflict(name, eventContext());
        }
    }
}
