/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.dsl.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.document.impl.ElasticsearchIndexFieldReference;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexCompositeNode;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexValueField;
import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.AbstractTypeMapping;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexSchemaBuildContext;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.reporting.EventContext;

class ElasticsearchIndexValueFieldBuilder<F> implements IndexSchemaFieldOptionsStep<ElasticsearchIndexValueFieldBuilder<F>, IndexFieldReference<F>>, ElasticsearchIndexNodeContributor, IndexSchemaBuildContext {

    private final AbstractElasticsearchIndexCompositeNodeBuilder parent;

    private final String relativeFieldName;

    private final String absoluteFieldPath;

    private final TreeNodeInclusion inclusion;

    private final ElasticsearchIndexValueFieldType<F> type;

    private boolean multiValued = false;

    private ElasticsearchIndexFieldReference<F> reference;

    ElasticsearchIndexValueFieldBuilder(AbstractElasticsearchIndexCompositeNodeBuilder parent, String relativeFieldName, TreeNodeInclusion inclusion, ElasticsearchIndexValueFieldType<F> type) {
        this.parent = parent;
        this.relativeFieldName = relativeFieldName;
        this.absoluteFieldPath = FieldPaths.compose(parent.getAbsolutePath(), relativeFieldName);
        this.inclusion = inclusion;
        this.type = type;
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexValueFieldBuilder<F> multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexFieldReference<F> toReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(ElasticsearchIndexNodeCollector collector, ElasticsearchIndexCompositeNode parentNode, Map<String, ElasticsearchIndexField> staticChildrenByNameForParent, AbstractTypeMapping parentMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
