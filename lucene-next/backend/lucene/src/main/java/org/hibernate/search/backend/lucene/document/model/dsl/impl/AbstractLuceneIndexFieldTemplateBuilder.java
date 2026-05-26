/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.model.dsl.impl;

import java.util.Map;
import org.hibernate.search.backend.lucene.document.model.impl.AbstractLuceneIndexFieldTemplate;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexCompositeNode;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexField;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldTemplateOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexSchemaBuildContext;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.pattern.spi.SimpleGlobPattern;
import org.hibernate.search.util.common.reporting.EventContext;

abstract class AbstractLuceneIndexFieldTemplateBuilder<S extends AbstractLuceneIndexFieldTemplateBuilder<S, T>, T extends AbstractLuceneIndexFieldTemplate<?>> implements IndexSchemaFieldTemplateOptionsStep<S>, LuceneIndexNodeContributor, IndexSchemaBuildContext {

    private final AbstractLuceneIndexCompositeNodeBuilder parent;

    protected final String absolutePath;

    protected final TreeNodeInclusion inclusion;

    private final String prefix;

    private SimpleGlobPattern relativePathGlob;

    private boolean multiValued = false;

    AbstractLuceneIndexFieldTemplateBuilder(AbstractLuceneIndexCompositeNodeBuilder parent, String templateName, TreeNodeInclusion inclusion, String prefix) {
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
    public void contribute(LuceneIndexNodeCollector collector, LuceneIndexCompositeNode parentNode, Map<String, LuceneIndexField> staticChildrenByNameForParent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract S thisAsS();

    protected abstract void doContribute(LuceneIndexNodeCollector collector, LuceneIndexCompositeNode parentNode, SimpleGlobPattern absolutePathGlob, boolean multiValued);
}
