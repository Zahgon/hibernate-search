/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.impl;

import java.util.List;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexObjectField;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.multitenancy.impl.MultiTenancyStrategy;
import org.apache.lucene.document.Document;

class LuceneNestedObjectFieldBuilder extends AbstractLuceneObjectFieldBuilder {

    LuceneNestedObjectFieldBuilder(LuceneIndexModel model, LuceneIndexObjectField schemaNode, AbstractLuceneDocumentElementBuilder parent) {
        super(model, schemaNode, parent, new LuceneDocumentContentImpl());
    }

    @Override
    void contribute(MultiTenancyStrategy multiTenancyStrategy, String tenantId, String routingKey, String rootId, List<Document> nestedDocuments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
