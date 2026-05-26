/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.dsl.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.document.model.impl.AbstractElasticsearchIndexFieldTemplate;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexCompositeNode;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexField;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.AbstractTypeMapping;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldTemplateOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexSchemaBuildContext;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.pattern.spi.SimpleGlobPattern;
import org.hibernate.search.util.common.reporting.EventContext;

abstract class AbstractElasticsearchIndexFieldTemplateBuilder<S extends AbstractElasticsearchIndexFieldTemplateBuilder<S, T>, T extends AbstractElasticsearchIndexFieldTemplate<?>> implements IndexSchemaFieldTemplateOptionsStep<S>, ElasticsearchIndexNodeContributor, IndexSchemaBuildContext {

    private final AbstractElasticsearchIndexCompositeNodeBuilder parent;

    protected final String absolutePath;

    private final TreeNodeInclusion inclusion;

    private final String prefix;

    private SimpleGlobPattern relativePathGlob;

    private boolean multiValued = false;

    AbstractElasticsearchIndexFieldTemplateBuilder(AbstractElasticsearchIndexCompositeNodeBuilder parent, String templateName, TreeNodeInclusion inclusion, String prefix) {
        this.parent = parent;
        this.absolutePath = FieldPaths.compose(parent.getAbsolutePath(), templateName);
        this.inclusion = inclusion;
        this.prefix = prefix;
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S matchingPathGlob(String pathGlob) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(ElasticsearchIndexNodeCollector collector, ElasticsearchIndexCompositeNode parentNode, Map<String, ElasticsearchIndexField> staticChildrenByNameForParent, AbstractTypeMapping parentMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract S thisAsS();

    protected abstract void doContribute(ElasticsearchIndexNodeCollector collector, ElasticsearchIndexCompositeNode parentNode, TreeNodeInclusion inclusion, SimpleGlobPattern absolutePathGlob, boolean multiValued);
}
