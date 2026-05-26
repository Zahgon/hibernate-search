/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.common.impl;

import java.util.List;
import org.hibernate.search.engine.search.common.spi.AbstractMultiIndexSearchIndexCompositeNodeContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;

public final class ElasticsearchMultiIndexSearchIndexCompositeNodeContext extends AbstractMultiIndexSearchIndexCompositeNodeContext<ElasticsearchSearchIndexCompositeNodeContext, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexCompositeNodeTypeContext, ElasticsearchSearchIndexNodeContext> implements ElasticsearchSearchIndexCompositeNodeContext, ElasticsearchSearchIndexCompositeNodeTypeContext {

    public ElasticsearchMultiIndexSearchIndexCompositeNodeContext(ElasticsearchSearchIndexScope<?> scope, String absolutePath, List<? extends ElasticsearchSearchIndexCompositeNodeContext> nodeForEachIndex) {
        super(scope, absolutePath, nodeForEachIndex);
    }

    @Override
    protected ElasticsearchSearchIndexCompositeNodeContext self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchIndexCompositeNodeTypeContext selfAsNodeType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchIndexCompositeNodeTypeContext typeOf(ElasticsearchSearchIndexCompositeNodeContext indexElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchIndexValueFieldContext<?> toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchSearchIndexNodeContext childInScope(String childRelativeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
