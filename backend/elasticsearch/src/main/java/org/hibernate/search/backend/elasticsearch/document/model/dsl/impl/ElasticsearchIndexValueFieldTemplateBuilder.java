/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.dsl.impl;

import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexCompositeNode;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexValueFieldTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.NamedDynamicTemplate;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.util.common.pattern.spi.SimpleGlobPattern;

class ElasticsearchIndexValueFieldTemplateBuilder extends AbstractElasticsearchIndexFieldTemplateBuilder<ElasticsearchIndexValueFieldTemplateBuilder, ElasticsearchIndexValueFieldTemplate> {

    private final ElasticsearchIndexValueFieldType<?> type;

    ElasticsearchIndexValueFieldTemplateBuilder(AbstractElasticsearchIndexCompositeNodeBuilder parent, String templateName, TreeNodeInclusion inclusion, ElasticsearchIndexValueFieldType<?> type, String prefix) {
        super(parent, templateName, inclusion, prefix);
        this.type = type;
    }

    @Override
    protected ElasticsearchIndexValueFieldTemplateBuilder thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doContribute(ElasticsearchIndexNodeCollector collector, ElasticsearchIndexCompositeNode parentNode, TreeNodeInclusion inclusion, SimpleGlobPattern absolutePathGlob, boolean multiValued) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
