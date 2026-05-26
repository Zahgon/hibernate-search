/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.model.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexCompositeNodeType;
import org.hibernate.search.engine.backend.document.model.spi.AbstractIndexRoot;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;

public final class ElasticsearchIndexRoot extends AbstractIndexRoot<ElasticsearchIndexRoot, ElasticsearchSearchIndexScope<?>, ElasticsearchIndexCompositeNodeType, ElasticsearchIndexField> implements ElasticsearchIndexCompositeNode {

    public ElasticsearchIndexRoot(ElasticsearchIndexCompositeNodeType type, Map<String, ElasticsearchIndexField> notYetInitializedStaticChildren) {
        super(type, notYetInitializedStaticChildren);
    }

    @Override
    protected ElasticsearchIndexRoot self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexObjectField toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexValueField<?> toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
