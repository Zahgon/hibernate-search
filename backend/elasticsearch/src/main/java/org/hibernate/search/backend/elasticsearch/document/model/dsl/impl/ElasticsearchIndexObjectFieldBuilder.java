/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.dsl.impl;

import java.util.Map;
import java.util.TreeMap;
import org.hibernate.search.backend.elasticsearch.document.impl.ElasticsearchIndexObjectFieldReference;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexCompositeNode;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexObjectField;
import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.AbstractTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicType;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexCompositeNodeType;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexObjectFieldBuilder;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.reporting.EventContext;

class ElasticsearchIndexObjectFieldBuilder extends AbstractElasticsearchIndexCompositeNodeBuilder implements IndexObjectFieldBuilder, ElasticsearchIndexNodeContributor {

    private final AbstractElasticsearchIndexCompositeNodeBuilder parent;

    private final String absoluteFieldPath;

    private final String relativeFieldName;

    private final TreeNodeInclusion inclusion;

    private boolean multiValued = false;

    private ElasticsearchIndexObjectFieldReference reference;

    ElasticsearchIndexObjectFieldBuilder(AbstractElasticsearchIndexCompositeNodeBuilder parent, String relativeFieldName, TreeNodeInclusion inclusion, ObjectStructure structure) {
        super(new ElasticsearchIndexCompositeNodeType.Builder(structure));
        this.parent = parent;
        String parentAbsolutePath = parent.getAbsolutePath();
        this.absoluteFieldPath = parentAbsolutePath == null ? relativeFieldName : FieldPaths.compose(parentAbsolutePath, relativeFieldName);
        this.relativeFieldName = relativeFieldName;
        this.inclusion = inclusion;
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexObjectFieldReference toReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(ElasticsearchIndexNodeCollector collector, ElasticsearchIndexCompositeNode parentNode, Map<String, ElasticsearchIndexField> staticChildrenByNameForParent, AbstractTypeMapping parentMapping) {
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
}
