/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.common.impl;

import java.util.List;
import org.hibernate.search.engine.search.common.spi.AbstractMultiIndexSearchIndexCompositeNodeContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;

public final class LuceneMultiIndexSearchIndexCompositeNodeContext extends AbstractMultiIndexSearchIndexCompositeNodeContext<LuceneSearchIndexCompositeNodeContext, LuceneSearchIndexScope<?>, LuceneSearchIndexCompositeNodeTypeContext, LuceneSearchIndexNodeContext> implements LuceneSearchIndexCompositeNodeContext, LuceneSearchIndexCompositeNodeTypeContext {

    public LuceneMultiIndexSearchIndexCompositeNodeContext(LuceneSearchIndexScope<?> scope, String absolutePath, List<? extends LuceneSearchIndexCompositeNodeContext> nodeForEachIndex) {
        super(scope, absolutePath, nodeForEachIndex);
    }

    @Override
    protected LuceneSearchIndexCompositeNodeContext self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneSearchIndexCompositeNodeTypeContext selfAsNodeType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneSearchIndexCompositeNodeTypeContext typeOf(LuceneSearchIndexCompositeNodeContext indexElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchIndexValueFieldContext<?> toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneSearchIndexNodeContext childInScope(String childRelativeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
