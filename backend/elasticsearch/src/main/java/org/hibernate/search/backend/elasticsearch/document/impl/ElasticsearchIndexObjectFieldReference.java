/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.impl;

import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexObjectField;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;

public class ElasticsearchIndexObjectFieldReference implements IndexObjectFieldReference {

    private ElasticsearchIndexObjectField schemaNode;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSchemaNode(ElasticsearchIndexObjectField schemaNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchIndexObjectField getSchemaNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
