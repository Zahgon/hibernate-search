/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.model.dsl.impl;

import java.util.Map;
import org.hibernate.search.backend.lucene.document.impl.LuceneIndexFieldReference;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexCompositeNode;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexValueField;
import org.hibernate.search.backend.lucene.logging.impl.MappingLog;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexSchemaBuildContext;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.reporting.EventContext;

class LuceneIndexValueFieldBuilder<F> implements IndexSchemaFieldOptionsStep<LuceneIndexValueFieldBuilder<F>, IndexFieldReference<F>>, LuceneIndexNodeContributor, IndexSchemaBuildContext {

    private final AbstractLuceneIndexCompositeNodeBuilder parent;

    private final String relativeFieldName;

    private final String absoluteFieldPath;

    private final TreeNodeInclusion inclusion;

    private final LuceneIndexValueFieldType<F> type;

    private boolean multiValued = false;

    private LuceneIndexFieldReference<F> reference;

    LuceneIndexValueFieldBuilder(AbstractLuceneIndexCompositeNodeBuilder parent, String relativeFieldName, TreeNodeInclusion inclusion, LuceneIndexValueFieldType<F> type) {
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
    public LuceneIndexValueFieldBuilder<F> multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexFieldReference<F> toReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(LuceneIndexNodeCollector collector, LuceneIndexCompositeNode parentNode, Map<String, LuceneIndexField> staticChildrenByNameForParent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
