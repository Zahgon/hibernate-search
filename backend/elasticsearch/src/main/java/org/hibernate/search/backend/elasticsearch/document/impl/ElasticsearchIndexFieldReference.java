/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.impl;

import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexValueField;
import org.hibernate.search.engine.backend.document.IndexFieldReference;

public class ElasticsearchIndexFieldReference<F> implements IndexFieldReference<F> {

    private ElasticsearchIndexValueField<F> schemaNode;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSchemaNode(ElasticsearchIndexValueField<F> schemaNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchIndexValueField<F> getSchemaNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
