/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.model.dsl.impl;

import java.util.Map;
import java.util.TreeMap;
import org.hibernate.search.backend.lucene.document.impl.LuceneIndexObjectFieldReference;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexCompositeNode;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexObjectField;
import org.hibernate.search.backend.lucene.logging.impl.MappingLog;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexCompositeNodeType;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexObjectFieldBuilder;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.reporting.EventContext;

class LuceneIndexObjectFieldBuilder extends AbstractLuceneIndexCompositeNodeBuilder implements IndexObjectFieldBuilder, LuceneIndexNodeContributor {

    private final AbstractLuceneIndexCompositeNodeBuilder parent;

    private final String absoluteFieldPath;

    private final String relativeFieldName;

    private final TreeNodeInclusion inclusion;

    private boolean multiValued = false;

    private LuceneIndexObjectFieldReference reference;

    LuceneIndexObjectFieldBuilder(AbstractLuceneIndexCompositeNodeBuilder parent, String relativeFieldName, TreeNodeInclusion inclusion, ObjectStructure structure) {
        super(new LuceneIndexCompositeNodeType.Builder(structure));
        this.parent = parent;
        this.absoluteFieldPath = FieldPaths.compose(parent.getAbsolutePath(), relativeFieldName);
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
    public void contribute(LuceneIndexNodeCollector collector, LuceneIndexCompositeNode parentNode, Map<String, LuceneIndexField> staticChildrenByNameForParent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexRootBuilder getRootNodeBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getAbsolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
